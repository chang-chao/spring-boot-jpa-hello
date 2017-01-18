package hello.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import hello.entity.Child;
import hello.entity.Parent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentRepositoryTest {
  @Autowired
  ParentRepository repository;

  // http://www.marcobehler.com/2014/06/25/should-my-tests-be-transactional/
  // @PersistenceContext
  // private EntityManager entityManager;

  @Test
  public void save() {
    Parent p = new Parent();
    p.setName("p1");

    Child c1 = new Child();
    c1.setName("c1");
    c1.setParent(p);

    Child c2 = new Child();
    c2.setName("c2");
    c2.setParent(p);

    p.setChilds(Lists.newArrayList(c1, c2));

    Parent savedParent = this.repository.save(p);

    List<Child> childs = savedParent.getChilds();
    childs.remove(1);

    Parent savedParent2 = this.repository.save(savedParent);

    Child c3 = new Child();
    c3.setName("c3");
    c3.setParent(savedParent2);

    c1.setParent(savedParent2);

    //savedParent2.setChilds(Lists.newArrayList(c1, c3));
    savedParent2.getChilds().add(c3);

    Parent savedParent3 = this.repository.save(savedParent2);

  }

  public void findAll() {
    Iterable<Parent> allParents = this.repository.findAll();
    ArrayList<Parent> parents = Lists.newArrayList(allParents);
    System.out.println(parents);
  }
}
