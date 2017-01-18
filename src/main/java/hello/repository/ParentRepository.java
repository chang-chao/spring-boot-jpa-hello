package hello.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import hello.entity.Parent;

public interface ParentRepository extends PagingAndSortingRepository<Parent, Long> {
}