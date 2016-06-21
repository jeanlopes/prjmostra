package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Area;
import br.edu.ifrs.mostra.models.Autor;
import br.edu.ifrs.mostra.models.AutorCurso;
import br.edu.ifrs.mostra.models.Campus;
import br.edu.ifrs.mostra.models.Categoria;
import br.edu.ifrs.mostra.models.Curso;
import br.edu.ifrs.mostra.models.Instituicao;
import br.edu.ifrs.mostra.models.Modalidade;
import br.edu.ifrs.mostra.models.Orientador;
import br.edu.ifrs.mostra.models.OrientadorCampus;
import br.edu.ifrs.mostra.models.Trabalho;
import br.edu.ifrs.mostra.models.TrabalhoAutorCurso;
import br.edu.ifrs.mostra.models.TrabalhoOrientadorCampus;
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
    public EntityManager em;
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
    
    protected JinqStream<Autor> autor() {
        return streams.streamAll(em, Autor.class);
    }
    
    protected JinqStream<AutorCurso> autorCurso() {
        return streams.streamAll(em, AutorCurso.class);
    }
    
    protected JinqStream<Trabalho> trabalho() {
        return streams.streamAll(em, Trabalho.class);           
    }
    
    protected JinqStream<Area> area() {
        return streams.streamAll(em, Area.class);
    }
    
    protected JinqStream<Categoria> categoria() {
        return streams.streamAll(em, Categoria.class);
    }
            
    protected JinqStream<Modalidade> modalidade() {
        return streams.streamAll(em, Modalidade.class);
    }
    
    protected JinqStream<Orientador> orientador() {
        return streams.streamAll(em, Orientador.class);
    }
    
    protected JinqStream<OrientadorCampus> orientadorCampus() {
        return streams.streamAll(em, OrientadorCampus.class);
    }
    
    protected JinqStream<TrabalhoAutorCurso> trabalhoAutorCurso() {
        return streams.streamAll(em, TrabalhoAutorCurso.class);
    }
    
    protected JinqStream<TrabalhoOrientadorCampus> trabalhoOrientadorCampus() {
        return streams.streamAll(em, TrabalhoOrientadorCampus.class);
    }
}
