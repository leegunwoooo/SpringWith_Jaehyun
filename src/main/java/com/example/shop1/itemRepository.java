package com.example.shop1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepository extends JpaRepository<item, Long> {
}
