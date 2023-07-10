package entities;

import java.time.Instant;
import java.util.Objects;

public class LogEntry implements Comparable <LogEntry> {
	private String username;
	private Instant timestamp;
	
	public LogEntry(String username, Instant timestamp) {	
		this.username = username;
		this.timestamp = timestamp;
	}

	public String getUsername() {
		return username;
	}

	public Instant getTimestamp() {
		return timestamp;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		return Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "LogEntry [username=" + username + ", timestamp=" + timestamp + "]";
	}

	@Override
	public int compareTo(LogEntry other) {
		return username.compareTo(other.getUsername());
	}
	
	
	
}
