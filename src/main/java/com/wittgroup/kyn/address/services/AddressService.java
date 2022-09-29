package com.wittgroup.kyn.address.services;

import com.wittgroup.kyn.address.db.entities.AddressEntity;
import com.wittgroup.kyn.address.db.entities.ApartmentEntity;
import com.wittgroup.kyn.address.db.entities.LocalityEntity;
import com.wittgroup.kyn.address.models.Address;
import com.wittgroup.kyn.address.db.repositories.AddressRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.wittgroup.kyn.address.db.repositories.ApartmentRepository;
import com.wittgroup.kyn.address.db.repositories.LocalityRepository;
import com.wittgroup.kyn.address.models.Apartment;
import com.wittgroup.kyn.address.models.Locality;
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

    public List<Address> findAll() {
        return addressRepository.findAll(Sort.by("id"))
                .stream()
                .map(entity -> mapToAddress(entity, new Address()))
                .collect(Collectors.toList());
    }

    public Address get(final UUID id) {
        return addressRepository.findById(id)
                .map(entity -> mapToAddress(entity, new Address()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(final Address address) {
        final AddressEntity entity = new AddressEntity();
        mapToAddressEntity(address, entity);
        return addressRepository.save(entity).getId();
    }

    public void update(final UUID id, final Address address) {
        final AddressEntity entity = addressRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToAddressEntity(address, entity);
        addressRepository.save(entity);
    }

    public void delete(final UUID id) {
        addressRepository.deleteById(id);
    }

    private Address mapToAddress(final AddressEntity entity, final Address address) {
        address.setId(entity.getId());
        address.setFlat(entity.getFlat());
        address.setLocality(entity.getLocality() == null ? null : mapToLocality(localityRepository.findById(entity.getLocality()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), new Locality()));
        address.setApartment(entity.getApartment() == null ? null : mapToApartment(apartmentRepository.findById(entity.getApartment()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), new Apartment()));
        return address;
    }

    private AddressEntity mapToAddressEntity(final Address address, final AddressEntity entity) {
        entity.setId(address.getId());
        entity.setFlat(address.getFlat());
        entity.setLocality(localityRepository.findById(address.getLocality().getId())
                .orElseGet(() -> localityRepository.save(mapToLocalityEntity(address.getLocality(), new LocalityEntity()))).getId());
        entity.setApartment(apartmentRepository.findById(address.getApartment().getId()).orElseGet(() -> apartmentRepository.save(mapToLocalityEntity(address.getApartment(), new ApartmentEntity()))).getId());
        return entity;
    }

    private Locality mapToLocality(final LocalityEntity entity, final Locality locality) {
        locality.setId(entity.getId());
        locality.setName(entity.getName());
        locality.setCity(entity.getCity());
        locality.setPinCode(entity.getPinCode());
        locality.setGeoLocation(entity.getGeoLocation());
        return locality;
    }

    private LocalityEntity mapToLocalityEntity(final Locality locality, final LocalityEntity entity) {
        entity.setId(locality.getId());
        entity.setName(locality.getName());
        entity.setCity(locality.getCity());
        entity.setPinCode(locality.getPinCode());
        entity.setGeoLocation(locality.getGeoLocation());
        return entity;
    }

    private Apartment mapToApartment(final ApartmentEntity entity, final Apartment apartment) {
        apartment.setId(entity.getId());
        apartment.setHoldingNumber(entity.getHoldingNumber());
        apartment.setName(entity.getName());
        apartment.setDisplayPicUrl(entity.getDisplayPicUrl());
        apartment.setGeoLocation(entity.getGeoLocation());
        return apartment;
    }

    private ApartmentEntity mapToLocalityEntity(final Apartment apartment, final ApartmentEntity entity) {
        entity.setId(apartment.getId());
        entity.setHoldingNumber(apartment.getHoldingNumber());
        entity.setName(apartment.getName());
        entity.setDisplayPicUrl(apartment.getDisplayPicUrl());
        entity.setGeoLocation(apartment.getGeoLocation());
        return entity;
    }
}
