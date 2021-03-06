package com.dmurphy.dnd.csheet.character;

import java.util.List;

public class CharClass {

	private String name;
	private String picName;
	private Role role;
	private Source source;
	private boolean[] availableArmors;
	private boolean[] availableWeapons;
	private String[] implement;
	private int[] defenseBonus;
	private int baseHP;
	private int hpPerLevel;
	private int healingSurgesPerDay;

	private String description = null;

	private List<Integer> availableSkillGroups;
	private int[] availableSkills;

	private String[] buildOptions;
	private List<String> features;

	public enum Role {
		LEADER("Leader"), DEFENDER("Defender"), CONTROLLER("Controller"), STRIKER(
				"Striker");

		private final String name;

		private Role(String s) {
			name = s;
		}

		public boolean equalsName(String otherName) {
			return (otherName == null) ? false : name.equals(otherName);
		}

		public String toString() {
			return name;
		}
	}

	public enum Source {
		ARCANE("Arcane"), DIVINE("Divine"), MARTIAL("Martial"), PSIONIC(
				"Psionic"), PRIMAL("Primal"), SHADOW("Shadow");

		private final String name;

		private Source(String s) {
			name = s;
		}

		public boolean equalsName(String otherName) {
			return (otherName == null) ? false : name.equals(otherName);
		}

		public String toString() {
			return name;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public boolean[] getAvailableArmors() {
		return availableArmors;
	}

	public void setAvailableArmors(boolean[] availableArmors) {
		this.availableArmors = availableArmors;
	}

	public String[] getImplement() {
		return implement;
	}

	public void setImplement(String[] implement) {
		this.implement = implement;
	}

	public int getBaseHP() {
		return baseHP;
	}

	public void setBaseHP(int baseHP) {
		this.baseHP = baseHP;
	}

	public int getHpPerLevel() {
		return hpPerLevel;
	}

	public void setHpPerLevel(int hpPerLevel) {
		this.hpPerLevel = hpPerLevel;
	}

	public int getHealingSurgesPerDay() {
		return healingSurgesPerDay;
	}

	public void setHealingSurgesPerDay(int healingSurgesPerDay) {
		this.healingSurgesPerDay = healingSurgesPerDay;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public boolean[] getAvailableWeapons() {
		return availableWeapons;
	}

	public void setAvailableWeapons(boolean[] availableWeapons) {
		this.availableWeapons = availableWeapons;
	}

	public int[] getDefenseBonus() {
		return defenseBonus;
	}

	public void setDefenseBonus(int[] defenseBonus) {
		this.defenseBonus = defenseBonus;
	}

	public String[] getBuildOptions() {
		return buildOptions;
	}

	public void setBuildOptions(String[] buildOptions) {
		this.buildOptions = buildOptions;
	}

	public List<Integer> getAvailableSkillGroups() {
		return availableSkillGroups;
	}

	public void setAvailableSkillGroups(List<Integer> availableSkillGroups) {
		this.availableSkillGroups = availableSkillGroups;
	}

	public int[] getAvailableSkills() {
		return availableSkills;
	}

	public void setAvailableSkills(int[] availableSkills) {
		this.availableSkills = availableSkills;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
