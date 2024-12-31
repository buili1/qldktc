package com.example.qldktc.Repo;

import com.example.qldktc.Model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<SinhVien, Long> {
    Optional<SinhVien> findOneByMasvAndPassword(String masv, String password);

    SinhVien findByMasv(String masv);

}
