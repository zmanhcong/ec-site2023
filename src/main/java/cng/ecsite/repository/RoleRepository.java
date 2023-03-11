package cng.ecsite.repository;

import cng.ecsite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "quey", nativeQuery = true)
    Role findROLE(String role);

    Role findByName(String admin);
}
