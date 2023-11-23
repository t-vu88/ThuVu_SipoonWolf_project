package com.example.thuvuFinalproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import com.example.thuvuFinalproject.domain.*;



@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {
	 @Autowired
	    private MemberRepository memberRepo;

	 @Autowired
	    private ActivityRepository activityRepo;
	 
	 @Autowired
	    private TeamRepository teamRepo;
	 
	 @Autowired
	    private AppUserRepository appUserRepo;
	 
	 @Test
	 public void findbyPlayerNUmberShouldReturnFirstName() {
		 List<Member> members = memberRepo.findByPlayerNumber(93);
		assertThat(members.get(0).getFirstName()).isEqualTo("Elias");
	 }
	 
	 @Test
	 public void testDeleteMember() {
	     
	     Member existingMember = memberRepo.findByFirstName("Viljo").get(0);

	     memberRepo.delete(existingMember);

	     Member deletedPlayer = memberRepo.findById(existingMember.getId()).orElse(null);

	     assertThat(deletedPlayer).isNull();
	 }
	 
	 @Test
	 public void findbyLastNameShouldReturnMemberRole() {
		 List<Member> members = memberRepo.findByLastName("Hirvonen");
		 assertThat(members).isNotEmpty();
		
		 boolean hasPlayerRole = false;
		    for (Member member : members) {
		        if ("player".equals(member.getRole())) {
		            hasPlayerRole = true;
		            break;
		        }
		    }
		    assertThat(hasPlayerRole).isTrue();

	 }
	 
	 @Test
	 public void findByTeamShouldReturnActivitiesForTeam() {
	     // testing with team U8
	     Team u8Team = teamRepo.findByName("U8").get(0);

	     List<Activity> activitiesForU8 = activityRepo.findByTeam(u8Team);

	     assertThat(activitiesForU8).isNotEmpty();
	 }
	 @Test
	    public void findByTeamNameShouldReturnTeam() {
	        List<Team> foundTeams = teamRepo.findByName("U8");

	        assertThat(foundTeams).isNotEmpty();
	        assertThat(foundTeams.get(0).getName()).isEqualTo("U8");
	       
	    }
	 
	 @Test
	    public void findByMembersFirstNameShouldReturnTeam() {
		 List<Team> teams = teamRepo.findByMembersFirstName("Niklas");
		 assertThat(teams).isNotNull();
	     assertThat(teams.get(0).getName()).isEqualTo("U8");
	       
	    }
	 @Test
	    void testFindByUsername() {
	      AppUser foundUser = appUserRepo.findByUsername("Johanna");
	      assertThat(foundUser.getUsername()).isEqualTo("Johanna");
	    }
	 
	 @Test
	 public void testAddNewMember() {
	     Member newMember = new Member();
	     newMember.setFirstName("Viljo");
	     newMember.setLastName("Pohjaranta");		
	     newMember.setRole("player");
	     newMember.setTeam(teamRepo.findByName("U8").get(0)); 

	     memberRepo.save(newMember);

	     assertThat(newMember.getId()).isNotNull();
	 }
	 
	 @Test
	 public void testEditMember() {
	     
	 	 Member existingMember = memberRepo.findByFirstName("Keiro").get(0);
	 	 existingMember.setPostcode("01480");
	 	 memberRepo.save(existingMember);
	 	 Member editedMember = memberRepo.findById(existingMember.getId()).orElse(null);
	     assertThat(editedMember.getId()).isNotNull();
	     assertThat(editedMember.getPostcode()).isEqualTo("01480");
	 }
	 
	 
	 
}


