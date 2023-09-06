package com.sportapp.cricketerentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="cricketer_lists")
public class Cricketer
{
	@Id
	private String capNumber;
	private String name;
	private String dateOfBirth;
	private long runs;
	private long wickets;
	private long catches;
	private String utilityForTeam;
	private String iplTeam;
	private String internationalTeam;
}
