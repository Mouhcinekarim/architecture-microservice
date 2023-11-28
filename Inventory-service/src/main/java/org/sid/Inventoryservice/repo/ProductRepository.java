package org.sid.Inventoryservice.repo;

import org.sid.Inventoryservice.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

}
