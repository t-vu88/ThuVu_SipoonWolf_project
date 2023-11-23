package com.example.thuvuFinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.thuvuFinalproject.domain.*;

@SpringBootApplication
public class ThuvuFinalprojectApplication {
	private static final Logger log = LoggerFactory.getLogger(ThuvuFinalprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ThuvuFinalprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner memberDemo(MemberRepository memberRepo, TeamRepository teamRepo,
			ActivityRepository activityRepo, AppUserRepository userRepo) {
		return (args) -> {
			log.info("Resetting the database");

	        /*Delete data from child tables first
	        activityRepo.deleteAll();
	        memberRepo.deleteAll();

	        // Delete data from parent tables
	        teamRepo.deleteAll();
	        userRepo.deleteAll();

	        log.info("Database reset complete");*/
	       
	        log.info("Save new data for testing");
	        // add team to the database
			 /*teamRepo.save(new Team ("U8"));
			 teamRepo.save(new Team ("U9"));
			 teamRepo.save(new Team ("U10"));
			 teamRepo.save(new Team ("U11"));*/
			 
			  
			 // add team player to the database
			 
			 /*memberRepo.save(new Member("Elias", "Arigh","player","vu@gmail.com","0400780585", 93, teamRepo.findByName("U8").get(0)));
			 memberRepo.save(new Member("Niklas", "Belov","player","belov@gmail.com","0401234567", 86, teamRepo.findByName("U8").get(0)));
			 memberRepo.save(new Member("Keiro", "Uibokand", "player","uikokand@gmail.com","0402345678",92,teamRepo.findByName("U8").get(0)));
			 memberRepo.save(new Member("Valteri", "Muuronen", "player","muuronen@gmail.com","0403456789", 12, teamRepo.findByName("U8").get(0)));
			 
			 
			 memberRepo.save(new Member("Alexander", "Kurel", "player","kurel@gmail.com","0404567891", 19,  teamRepo.findByName("U9").get(0))); 
			 memberRepo.save(new Member("Nuuti", "Halonen","player","halonen@gmail.com","0405678912", 45, teamRepo.findByName("U9").get(0)));
			 memberRepo.save(new Member("Aarni", "Nuutinen","player","nuutinen@gmail.com","0406789123",15, teamRepo.findByName("U9").get(0)));
			 memberRepo.save(new Member("Simon", "Ahonen","player","ahonen@gmail.com","0407891234", 7, teamRepo.findByName("U9").get(0)));
			 
			 memberRepo.save(new Member("Joonatan", "Sapman","player","sapman@gmail.com","0408912345",29, teamRepo.findByName("U10").get(0)));
			 memberRepo.save(new Member("Joona", "Vainiopää","player","vainiopaa@gmail.com","0409123456",65, teamRepo.findByName("U10").get(0)));
			 memberRepo.save(new Member("Noa", "Koskinen","player","koskinen@gmail.com","0412345678",3, teamRepo.findByName("U10").get(0)));
			 memberRepo.save(new Member("Leo", "Valtanen","player","valtanen@gmail.com","0413456789", 22, teamRepo.findByName("U10").get(0)));
			 
			 
			 memberRepo.save(new Member("Theresa", "Hirvonen","player","hirvonen@gmail.com","0414567891",39, teamRepo.findByName("U11").get(0)));
			 memberRepo.save(new Member("Knut", "KoffMan","player","koffman@gmail.com","0415678912", 10, teamRepo.findByName("U11").get(0)));
			 memberRepo.save(new Member("Joel", "Hänninen","player","hanninen@gmail.com","04156789123", 18,teamRepo.findByName("U11").get(0)));
			 memberRepo.save(new Member("Jooa", "Ikonen","player","ikonen@gmail.com","04167891234", 29, teamRepo.findByName("U11").get(0))); 
			 
			 
			 // add team management member to the database
			 memberRepo.save(new Member("Aso", "Arigh", "team leader","aso@gmail.com","0417891234", teamRepo.findByName("U8").get(0)));
			 memberRepo.save(new Member("Matti", "Hirvonen", " main coach","matti@gmail.com","0418912345", teamRepo.findByName("U8").get(0)));
			 
			 memberRepo.save(new Member("Servei", "Kovanovich", " main coach","servei@gmail.com","0419123456", teamRepo.findByName("U9").get(0)));
			 memberRepo.save(new Member("Dimitri", "Belov", "team leader","dimitri@gmail.com","0423456789", teamRepo.findByName("U9").get(0)));
			 
			 memberRepo.save(new Member("Ville", "Muuronen","team leader","ville@gmail.com","0424567891", teamRepo.findByName("U10").get(0)));
			 memberRepo.save(new Member("Jarkko", "Nieminen"," main coach","jarkko@gmail.com","0425678912", teamRepo.findByName("U10").get(0)));
			 
			 memberRepo.save(new Member("Miia", "Podschivalow","team leader","miia@gmail.com","0426789123", teamRepo.findByName("U11").get(0)));
			 memberRepo.save(new Member("Antti", "Nuutinen","main coach","hirvonen@gmail.com","0427891234", teamRepo.findByName("U11").get(0)));*/
			 
			 //addd activitiies
			 
			 /*activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,11,17,13,0),LocalDateTime.of(2023,11,10,15,0),teamRepo.findByName("U8").get(0)));
			  
			 activityRepo.save(new Activity("game", "Matinkylä jäähalli", LocalDateTime.of(2023,11,18, 9,0),LocalDateTime.of(2023,11,16,12,0),teamRepo.findByName("U8").get(0),"be present in the arena 1 hour before the game starts"));
			 activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,11,20,18,0),LocalDateTime.of(2023,11,20,19,0),teamRepo.findByName("U8").get(0)));
			 activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,11,24,17,0),LocalDateTime.of(2023,11,10,18,0),teamRepo.findByName("U8").get(0)));
			 activityRepo.save(new Activity("game", "Sipoo jäähalli", LocalDateTime.of(2023,12,3,10,0),LocalDateTime.of(2023,12,3,15,0),teamRepo.findByName("U8").get(0),"Pikkujoulupelitällit"));
			 
			 activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,11,17,18,0),LocalDateTime.of(2023,11,10,19,0),teamRepo.findByName("U9").get(0),"training together with U8"));
			 activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,11,20,17,0),LocalDateTime.of(2023,11,20,18,0),teamRepo.findByName("U9").get(0)));
			 activityRepo.save(new Activity("game", "Mäntsälä jäähalli",LocalDateTime.of(2023,11,19,9,0),LocalDateTime.of(2023,11,19,17,0),teamRepo.findByName("U9").get(0),"Leijonaliija games with Jää-Tiikerit ja LJK"));
			 activityRepo.save(new Activity("game", "Sipoo jäähalli",LocalDateTime.of(2023,12,10,10,0),LocalDateTime.of(2023,12,10,12,0),teamRepo.findByName("U9").get(0),"Leijonaliija games Jää-Tiikerit" ));
			 
			 activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,11,17,13,0),LocalDateTime.of(2023,11,10,15,0),teamRepo.findByName("U10").get(0)));
			 activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,12,3,9,0),LocalDateTime.of(2023,12,3,10,0),teamRepo.findByName("U10").get(0)));
			 activityRepo.save(new Activity("game", "Mätinkylä jäähalli",LocalDateTime.of(2023,11,19,16,30),LocalDateTime.of(2023,11,19,18,0),teamRepo.findByName("U10").get(0), "Leijonaliiga games with  REDS, KJT"));
			 activityRepo.save(new Activity("game", "Kellokoski jäähalli",LocalDateTime.of(2023,12,9,13,30),LocalDateTime.of(2023,12,9,15,30),teamRepo.findByName("U10").get(0), "Leijonaliiga games with  HAUKAT"));
			 
			 activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,11,24,17,0),LocalDateTime.of(2023,11,24,19,0),teamRepo.findByName("U11").get(0)));
			 activityRepo.save(new Activity("training", "Sipoo jäähalli",LocalDateTime.of(2023,12,1,18,0),LocalDateTime.of(2023,11,10,19,0),teamRepo.findByName("U11").get(0)));
			 activityRepo.save(new Activity("game", "Sipoo jäähalli",LocalDateTime.of(2023,11,16,12,30),LocalDateTime.of(2023,11,26,14,30),teamRepo.findByName("U11").get(0),"practice game with Kiekko-Espoo"));
			 activityRepo.save(new Activity("game", "Kaarela jäähalli",LocalDateTime.of(2023,12,3,13,30),LocalDateTime.of(2023,12,3,15,30),teamRepo.findByName("U11").get(0)));
			 */
			 
			 //	Create users ( username/password): 
			//U8: Johanna/johannaU8 , Matti/mattiU8, Arigh/arighU8
			AppUser user1 = new AppUser("Johanna", "$2a$10$VWrOeG58ooVqjtdsIgjx1.CxsOm5oIeBVrmK5U47OEG11QXRjJ1YK","johanna@gmail.com", "PARENT");
			AppUser user2 = new AppUser ("Matti","$2a$10$yxd5EyUF6cKW2yrh7fZRyOjx03uxRS.DoACGSeupxytnhrpNZctii" ,"matti@gmail.com","TEAM_MANAGEMENT");
			AppUser user3 = new AppUser("Arigh","$2a$10$s9Z0i8rWqfCiFMKCvSruY.X2zVl05UkWye4bK2s0SNgp2G.EBt6vS","arigh@gmail.com","TEAM_MANAGEMENT");
			user1.setTeam(teamRepo.findByName("U8").get(0));
			user2.setTeam(teamRepo.findByName("U8").get(0));
			user3.setTeam(teamRepo.findByName("U8").get(0));
			
			// U9 : Konsta/konstaU9, Dimitri/dimitriU9, Servei/serveiU9
			AppUser user4 = new AppUser ("Konsta","$2a$10$FWY6qdILruiaGoQNXq9noOpzPsmRpHsXqgAI51nJSddbUq6nhcvje" ,"konsta@gmail.com","PARENT");
			AppUser user5 = new AppUser("Dimitri","$2a$10$FRhAsj7UHTjVF0DDDP0WDeXbj0BJxX9rNkVV.fVLDYfwH0xUaHq1G","dimitri@gmail.com","TEAM_MANAGEMENT");
			AppUser user6 = new AppUser("Servei","$2a$10$QBPrNXdxU0BR9S/../q9qOEAqvosoZVDT3hg9zmaaEVBrcZjDkYEa","servei@gmail.com","TEAM_MANAGEMENT");
			user4.setTeam(teamRepo.findByName("U9").get(0));
			user5.setTeam(teamRepo.findByName("U9").get(0));
			user6.setTeam(teamRepo.findByName("U9").get(0));
			
			//U10: Teemu/teemuU10 , Ville/ villeU10, Jarkko/jarkkoU10
			AppUser user7 = new AppUser ("Teemu","$2a$10$DiOxwbi82ASwe7VVS7klVubyyUeRoy21dMOGqyrFPCiq82FTMneyO" ,"teemu@gmail.com","PARENT");
			AppUser user8 = new AppUser("Ville","$2a$10$VNTMjxydW5WOdUqfffjrxuSgsp/YjOrdzVzK4U0jTgJBM0le3d/1K","ville@gmail.com","TEAM_MANAGEMENT");
			AppUser user9 = new AppUser("Jarkko", "$2a$10$Q9Fb9YR528gRtAY1FZqaJOLU9g70abK46W8B6iyfqx.EkjthTDtJG","jarkko@gmail.com", "TEAM_MANAGEMENT");
			user7.setTeam(teamRepo.findByName("U10").get(0));
			user8.setTeam(teamRepo.findByName("U10").get(0));
			user9.setTeam(teamRepo.findByName("U10").get(0));
			
			// u11 : Viljo/viljoU11, Miia/miiaU11, Antti/anttiU11
			AppUser user10 = new AppUser ("Viljo","$2a$10$NTE3S9VWndjiKXz01Dz0YebsqjeOOv1s9tDSjkOCtSd9OZ17ds3uW" ,"viljo@gmail.com","PARENT");
			AppUser user11 = new AppUser("Miia","$2a$10$ma6AIZ0B0oDgalanKZfosuW00x06ZnMJMZWhYJPBtWAEyqc4r0cfq","miia@gmail.com","TEAM_MANAGEMENT");
			AppUser user12 = new AppUser("Antti", "$2a$10$EESwiMxPbOwC5wShVpSDsurC.PIpZX/4IFOLKfUU13SiphM1c/ade","antti@gmail.com", "TEAM_MANAGEMENT");
			user10.setTeam(teamRepo.findByName("U11").get(0));
			user11.setTeam(teamRepo.findByName("U11").get(0));
			user12.setTeam(teamRepo.findByName("U11").get(0));
			
			
			
			/*userRepo.save(user1);
			userRepo.save(user2);
			userRepo.save(user3);
			userRepo.save(user4);
			userRepo.save(user5);
			userRepo.save(user6);
			userRepo.save(user7);
			userRepo.save(user8);
			userRepo.save(user9);
			userRepo.save(user10);
			userRepo.save(user11);
			userRepo.save(user12);*/
			
			System.out.println("in command line runner");
			log.info("fetch all members");
			for (Member member : memberRepo.findAll()) {
				log.info(member.toString());
			}
		};
	}
}
