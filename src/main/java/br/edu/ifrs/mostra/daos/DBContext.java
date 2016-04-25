package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Campus;
import br.edu.ifrs.mostra.models.Curso;
import br.edu.ifrs.mostra.models.Instituicao;
import br.edu.ifrs.mostra.models.Usuario;
import javax.inject.Inject;
import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jean
 */
public class DBContext {
    
    //@PersistenceContext(unitName = "mostraPU")
    private static EntityManagerFactory entityManagerFactory;
    private static JinqJPAStreamProvider streams;
    protected EntityManager em;
    private static DBContext instance = null;
    
    private DBContext () {
        
      entityManagerFactory = Persistence.createEntityManagerFactory("mostraPU");
      this.em = entityManagerFactory.createEntityManager();
      streams = new JinqJPAStreamProvider(entityManagerFactory);

      // Configure Jinq to output the queries it executes
      streams.setHint("queryLogger", (JPAQueryLogger) (query, positionParameters, namedParameters) ->
         System.out.println("  " + query));
    } 
   
    public static DBContext getInstance (){
        if (instance == null) {
            instance = new DBContext();
        }
        
        return instance;
    }
    
    // Entidades
    
    /**
     * Obtém as instituições para funções lambda
     * @return as instituições
     */
    protected JinqStream<Instituicao> instituicao(){
        return streams.streamAll(em, Instituicao.class);
    }
    
    protected JinqStream<Campus> campus() {
        return streams.streamAll(em, Campus.class);
    }
    
    protected JinqStream<Curso> curso() {
        return streams.streamAll(em, Curso.class);
    }
    
    protected JinqStream<Usuario> usuario() {
        return streams.streamAll(em, Usuario.class);
    }
    
    
}
