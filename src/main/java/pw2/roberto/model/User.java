package pw2.roberto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends PanacheEntity {

	public String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Message> messages;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Channel> channels;

	public User() {

		this.messages = new ArrayList<>();
		this.channels = new ArrayList<>();
	}

	public void addMessage(Message message) {
		this.messages.add(message);
	}

	public void addChannel(Channel channel) {
		this.channels.add(channel);
	}
}
