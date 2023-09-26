package hibernate.entities;

import jakarta.persistence.*;

import java.util.UUID;
import hibernate.entities.Instructor;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {


    @Id
    @Column(name = "details_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "instructor_youtube_channel")
    private String youtubeChannel;
    @Column(name = "instructor_hobbies")
    private String instructorHobbies;

    @OneToOne()
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public InstructorDetails(){

    }

    public InstructorDetails( String youtubeChannel, String instructorHobbies, Instructor instructor) {
        this.youtubeChannel = youtubeChannel;
        this.instructorHobbies = instructorHobbies;
        this.instructor = instructor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getInstructorHobbies() {
        return instructorHobbies;
    }

    public void setInstructorHobbies(String instructorHobbies) {
        this.instructorHobbies = instructorHobbies;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", instructorHobbies='" + instructorHobbies + '\'' +
                '}';
    }
}
