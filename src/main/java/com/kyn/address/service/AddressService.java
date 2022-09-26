package com.kyn.address.service;

import com.kyn.address.domain.Address;
import com.kyn.address.domain.Locality;
import com.kyn.address.model.AddressDTO;
import com.kyn.address.repos.AddressRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kyn.address.repos.ApartmentRepository;
import com.kyn.address.repos.LocalityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final LocalityRepository localityRepository;
    private final ApartmentRepository apartmentRepository;

    public AddressService(final AddressRepository addressRepository, final LocalityRepository localityRepository, final ApartmentRepository apartmentRepository) {
        this.addressRepository = addressRepository;
        this.localityRepository = localityRepository;
        this.apartmentRepository = apartmentRepository;
    }

    public List<AddressDTO> findAll() {
        return addressRepository.findAll(Sort.by("id"))
                .stream()
                .map(address -> mapToDTO(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    public AddressDTO get(final UUID id) {
        return addressRepository.findById(id)
                .map(address -> mapToDTO(address, new AddressDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(final AddressDTO addressDTO) {
        final Address address = new Address();
        mapToEntity(addressDTO, address);
        return addressRepository.save(address).getId();
    }

    public void update(final UUID id, final AddressDTO addressDTO) {
        final Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(addressDTO, address);
        addressRepository.save(address);
    }

    public void delete(final UUID id) {
        addressRepository.deleteById(id);
    }

    private AddressDTO mapToDTO(final Address address, final AddressDTO addressDTO) {
        addressDTO.setId(address.getId());
        addressDTO.setFlat(address.getFlat());
        addressDTO.setApartment(address.getApartment() == null ? null : apartmentRepository.findById(address.getApartment()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        addressDTO.setLocality(address.getLocality() == null ? null : localityRepository.findById(address.getLocality()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return addressDTO;
    }

    private Address mapToEntity(final AddressDTO addressDTO, final Address address) {
        address.setId(addressDTO.getId());
        address.setFlat(addressDTO.getFlat());
        address.setLocality(localityRepository.findById(addressDTO.getLocality().getId())
                .orElseGet(() -> localityRepository.save(addressDTO.getLocality())).getId());
        address.setApartment(apartmentRepository.findById(addressDTO.getApartment().getId()).orElseGet(() -> apartmentRepository.save(addressDTO.getApartment())).getId());
        return address;
    }

}
