package entities;

import java.util.Objects;

public class Candidat implements Comparable<Candidat> {
	private String name;
	private Integer numVotes;

	public Candidat() {
	}

	public Candidat(String name, Integer numVotes) {
		this.name = name;
		this.numVotes = numVotes;
	}

	public String getName() {
		return name;
	}

	public Integer getNumVotes() {
		return numVotes;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(numVotes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidat other = (Candidat) obj;
		return Objects.equals(numVotes, other.numVotes);
	}
	
	

	@Override
	public String toString() {
		return name + ": " + numVotes;
	}

	@Override
	public int compareTo(Candidat other) {
		return numVotes.compareTo(other.getNumVotes());   
	}

}
