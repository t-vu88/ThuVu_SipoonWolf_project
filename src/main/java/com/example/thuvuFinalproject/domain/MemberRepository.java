package com.example.thuvuFinalproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MemberRepository extends CrudRepository<Member, Long> {
	List<Member> findByTeam(Team team);
	List<Member> findByLastName(String lastName);
	List<Member> findByPlayerNumber(int playerNumber);
	List<Member> findByFirstName(String firstName);

}
