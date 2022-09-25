package com.kyn.address.service;

import com.kyn.address.domain.Address;
import com.kyn.address.domain.Locality;
import com.kyn.address.model.AddressDTO;
import com.kyn.address.repos.AddressRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kyn.address.repos.LocalityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final LocalityRepository localityRepository;

    public AddressService(final AddressRepository addressRepository, final LocalityRepository localityRepository) {
        this.addressRepository = addressRepository;
        this.localityRepository = localityRepository;
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
        return addressDTO;
    }

    private Address mapToEntity(final AddressDTO addressDTO, final Address address) {
        Locality locality = addressDTO.getLocality() == null ? Locality.EMPTY : localityRepository.findById(addressDTO.getLocality()) .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "locality not found"));
        address.setLocality(locality);
        return address;
    }

}
