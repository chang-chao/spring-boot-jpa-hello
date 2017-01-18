package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Child {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "parent_id", nullable = false)
  private Parent parent;

  private String name;

}
