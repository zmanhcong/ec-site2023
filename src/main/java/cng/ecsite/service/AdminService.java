package cng.ecsite.service;

import cng.ecsite.dto.AdminDto;
import cng.ecsite.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);

}
