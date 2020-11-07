package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.Admin;
import com.trip.tripsoda.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;

    public Page<Admin> getAdminList(String country, int size, Pageable pageable) {
        return adminRepository.findAll(country, size, pageable);
    }

    @Transactional
    public void register(Admin admin) {
        adminRepository.save(admin);
    }

    @Transactional
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
