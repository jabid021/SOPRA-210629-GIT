package eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.model.ElementAchat;
import eshop.model.ElementAchatKey;

public interface ElementAchatRepository extends JpaRepository<ElementAchat, ElementAchatKey> {

}
