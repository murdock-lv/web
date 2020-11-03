package com.bla.laa.model.mysql;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource( collectionResourceRel = "address", path = "address" )
public interface AddressSqlRepository  extends PagingAndSortingRepository<Address, Integer>  {

    Optional<Address> findById(Integer id);

    @Query(value = "SELECT * FROM ADDRESS a WHERE a.parent = :parent ", nativeQuery = true)
    Page<Address> findByParentNative(@Param("parent") Integer parent, Pageable pageable);

    //@Query(value = "SELECT * FROM ADDRESS a WHERE a.parent = :parent ", nativeQuery = true)
    Page<Address> findByParentAndLevel(@Param("parent") Integer parent, @Param("level") VkurTips.TipsEnum level, Pageable pageable);


}
