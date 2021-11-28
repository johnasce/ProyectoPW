package ec.edu.ups.pw.utils;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
  @Produces
  @PersistenceContext(name = "proyectoPersistenceUnit")
  private EntityManager em;
}