package com.example.thuvuFinalproject.web;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.thuvuFinalproject.domain.*;
import org.springframework.ui.Model;

@Controller
public class TeamController {

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private TeamRepository teamRepo;

	@Autowired
	private ActivityRepository activityRepo;
	

	@RequestMapping("/")
	public String SipooWolfPage() {

		return "index";
	}
	
	@RequestMapping(value = "/u8", method = RequestMethod.GET)
    public String teamU8(Model model) {
        model.addAttribute("teamName", "U8");
        return "generalInfo";
    }

    @RequestMapping(value = "/u9", method = RequestMethod.GET)
    public String teamU9(Model model) {
        model.addAttribute("teamName", "U9");
        return "generalInfo";
    }

	@RequestMapping(value = "/u10", method = RequestMethod.GET)
	public String teamU10(Model model) {
        model.addAttribute("teamName", "U10");
        return "generalInfo";
    }

	@RequestMapping(value = "/u11", method = RequestMethod.GET)
	public String teamU11(Model model) {
        model.addAttribute("teamName", "U11");
        return "generalInfo";
    }
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	// team info in details
	@RequestMapping(value = {"/info"}, method = RequestMethod.GET)
	public String teamInfo(@RequestParam String team, Model model) {
	    Team selectedTeam = teamRepo.findByName(team).get(0);
	    List<Member> teamMembers = memberRepo.findByTeam(selectedTeam);
	    List<Activity> teamActivities = activityRepo.findByTeam(selectedTeam);

	    // Add data to the model
	    model.addAttribute("teamName", team);
	    model.addAttribute("members", teamMembers);
	    model.addAttribute("activities", teamActivities);

	    return "teaminfo";
	}
	// team info for visitors without logging in or signing up
	@RequestMapping(value = {"/teaminfo"}, method = RequestMethod.GET)
	public String teamInfoForVisitors(@RequestParam String team, Model model) {
	    Team selectedTeam = teamRepo.findByName(team).get(0);
	    List<Member> teamMembers = memberRepo.findByTeam(selectedTeam);
	    List<Activity> teamActivities = activityRepo.findByTeam(selectedTeam);

	    // Add data to the model
	    model.addAttribute("teamName", team);
	    model.addAttribute("members", teamMembers);
	    model.addAttribute("activities", teamActivities);

	    return "teaminfoForVisitor";
	}
	// add new player
	@RequestMapping(value = "/addplayer", method = RequestMethod.GET)
	public String addNewPlayer(@RequestParam("team") String teamName, Model model) {
	    Member newPlayer = new Member();
	    newPlayer.setRole("player");
	    Team team = teamRepo.findByName(teamName).get(0);
	    newPlayer.setTeam(team);
	    model.addAttribute("newMember", newPlayer);
	    model.addAttribute("teams", teamRepo.findAll());
	    return "addnewplayer";
	}
	
	// edit player and team management member and activity
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editPlayer(@PathVariable("id") Long id, @RequestParam("team") String teamName,@RequestParam("entityType") String entityType,  Model model) {
			model.addAttribute("teamName", teamName);
			model.addAttribute("teams", teamRepo.findAll());
			if ("player".equals(entityType)) {
				model.addAttribute("player",memberRepo.findById(id));
				return "editPlayer";
			} else if ("member".equals(entityType)) {
				model.addAttribute("teamManagementMember",memberRepo.findById(id));
				return "editTeamManagement";
			}
			model.addAttribute("activity",activityRepo.findById(id));
			System.out.println(activityRepo.findById(id).toString());
			return "editActivity";
			
	}

	// add new team management
	@RequestMapping(value = "/addmember", method = RequestMethod.GET)
	public String addNewTeamManagement(@RequestParam("team") String teamName,Model model) {
	    Member newMember = new Member();
	    Team team = teamRepo.findByName(teamName).get(0);
	    newMember.setTeam(team);
	    model.addAttribute("newMember", newMember);
	    model.addAttribute("teams", teamRepo.findAll());
	    return "addNewTeamManagement";
	}
	
	//add new activity
	@RequestMapping(value = "/addActivity", method = RequestMethod.GET)
	public String addNewActivity(@RequestParam("team") String teamName, Model model) {
		Activity newActivity = new Activity();
		Team team = teamRepo.findByName(teamName).get(0);
	    newActivity.setTeam(team);
	    model.addAttribute("newActivity", newActivity);
	    model.addAttribute("teams", teamRepo.findAll());
	    return "addNewActivity";
	}
	
	// delete player, team management as well as activity
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTeamMember(@PathVariable("id") Long id, @RequestParam("entityType") String entityType, @RequestParam("team") String teamName,Model model) 
		{
			if ("activity".equals(entityType)) {
		        activityRepo.deleteById(id);
		    } else {
		    	memberRepo.deleteById(id);
		    }
		    return "redirect:/info?team=" + teamName;
		}
	
	//delete all activities that already passed.
		@RequestMapping(value = "/deletePastActivities", method = RequestMethod.GET)
	    public String deletePastActivities(@RequestParam ("team") String teamName, Model model) {
	        LocalDateTime now = LocalDateTime.now();

	        List<Activity> activities = activityRepo.findAll();

	        for (Activity activity : activities) {
	            if (activity.getBeginTime().isBefore(now)) {
	                activityRepo.deleteById(activity.getId());
	            }
	        }

	        return "redirect:/info?team=" + teamName;
	    }
	// save new member ( player and team management)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Member newMember){
		memberRepo.save(newMember);
		 String teamName = newMember.getTeam().getName();
		return "redirect:/info?team=" + teamName;
	}
	
	//save new activity
	@RequestMapping(value = "/saveActivity", method = RequestMethod.POST)
	public String save(Activity newActivity){
		activityRepo.save(newActivity);
		String teamName = newActivity.getTeam().getName();
		return "redirect:/info?team=" + teamName;
	}
}
