package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.daos.AreaDao;
import br.edu.ifrs.mostra.daos.AutorCursoDao;
import br.edu.ifrs.mostra.daos.CategoriaDao;
import br.edu.ifrs.mostra.daos.ModalidadeDao;
import br.edu.ifrs.mostra.daos.OrientadorCampusDao;
import br.edu.ifrs.mostra.daos.TrabalhoAutorCursoDao;
import br.edu.ifrs.mostra.daos.TrabalhoDao;
import br.edu.ifrs.mostra.daos.TrabalhoOrientadorCampusDao;
import br.edu.ifrs.mostra.dto.AreaDto;
import br.edu.ifrs.mostra.dto.AutorCursoDto;
import br.edu.ifrs.mostra.dto.CategoriaDto;
import br.edu.ifrs.mostra.dto.ModalidadeDto;
import br.edu.ifrs.mostra.dto.NivelDto;
import br.edu.ifrs.mostra.dto.OrientadorCampusDto;
import br.edu.ifrs.mostra.dto.TrabalhoDto;
import br.edu.ifrs.mostra.models.Area;
import br.edu.ifrs.mostra.models.AutorCurso;
import br.edu.ifrs.mostra.models.Categoria;
import br.edu.ifrs.mostra.models.Modalidade;
import br.edu.ifrs.mostra.models.OrientadorCampus;
import br.edu.ifrs.mostra.models.Trabalho;
import br.edu.ifrs.mostra.models.TrabalhoAutorCurso;
import br.edu.ifrs.mostra.models.TrabalhoOrientadorCampus;
import br.edu.ifrs.mostra.models.Usuario;
import com.google.gson.Gson;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jean
 */
@Path("/trabalho")
@Stateless
public class TrabalhoBean {
    
    @EJB
    private LoginBean loginBean;

    @Inject
    private TrabalhoDao trabalhoDao;
    
    @Inject 
    private AreaDao areaDao;
    
    @Inject
    private CategoriaDao categoriaDao;
    
    @Inject
    private ModalidadeDao modalidadeDao;
    
    @Inject
    private AutorCursoDao autorCursoDao;
    
    @Inject
    private OrientadorCampusDao orientadorCampusDao;
    
    @Inject
    private TrabalhoAutorCursoDao trabalhoAutorCursoDao;
    
    @Inject
    private TrabalhoOrientadorCampusDao trabalhoOrientadorCampusDao;
    
    private final Gson gson = new Gson();
    
    @GET
    @Path("/listar_trabalhos")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarTrabalhos() {
        
        List<Trabalho> trabalhos = trabalhoDao.listAll();
        List<br.edu.ifrs.mostra.dto.TrabalhoDto> trabalhosDto = new ArrayList<>();
        
        trabalhos.forEach((trabalho) -> {
            br.edu.ifrs.mostra.dto.TrabalhoDto trab = new br.edu.ifrs.mostra.dto.TrabalhoDto();
            
            trab.setStatus(trabalho.getStatus());
            trab.setIdTrabalho(trabalho.getIdTrabalho());
            trab.setTitulo(trabalho.getTitulo());
            
            trabalhosDto.add(trab);
        });
        
        String listaTrabalhosDto = gson.toJson(trabalhosDto);
        
        return listaTrabalhosDto;
    }
    
    @GET
    @Path("/areas")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarAreas() {
        
        List<Area> areas = areaDao.listAll();
        List<br.edu.ifrs.mostra.dto.AreaDto> areasDto = new ArrayList<>();
        
        areas.forEach((area) -> {
            br.edu.ifrs.mostra.dto.AreaDto areaDto = new br.edu.ifrs.mostra.dto.AreaDto();
            areaDto.setIdArea(area.getIdArea());
            areaDto.setNome(area.getNome());
            
            areasDto.add(areaDto);
        });
        
        String listaAreas = gson.toJson(areasDto);
        
        return listaAreas;
    }
    
    @GET
    @Path("/categorias")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarCategorias() {
        
        List<Categoria> categorias = categoriaDao.listAll();
        List<br.edu.ifrs.mostra.dto.CategoriaDto> categoriasDto = new ArrayList<>();
        
        categorias.forEach((categoria) -> {
            br.edu.ifrs.mostra.dto.CategoriaDto categoriaDto = new br.edu.ifrs.mostra.dto.CategoriaDto();
            categoriaDto.setIdCategoria(categoria.getIdCategoria());
            categoriaDto.setNome(categoria.getNome());
            
            categoriasDto.add(categoriaDto);
        });
        
        String listaCategorias = gson.toJson(categoriasDto);
        
        return listaCategorias;
    }
    
    @GET
    @Path("/modalidades")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarModalidades() {
        
        List<Modalidade> modalidades = modalidadeDao.listAll();
        List<br.edu.ifrs.mostra.dto.ModalidadeDto> modalidadesDto = new ArrayList<>();
        
        modalidades.forEach((modalidade) -> {
            br.edu.ifrs.mostra.dto.ModalidadeDto modalidadeDto = new br.edu.ifrs.mostra.dto.ModalidadeDto();
            modalidadeDto.setIdModalidade(modalidade.getIdModalidade());
            modalidadeDto.setNome(modalidade.getNome());
            
            modalidadesDto.add(modalidadeDto);
        });
        
        String modalidadeAreas = gson.toJson(modalidadesDto);
        
        return modalidadeAreas;
    }
    
    @GET
    @Path("/buscar_autor/{termo}")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarAutor(@PathParam("termo") String termo) {
        
        List<AutorCurso> autoresCurso = autorCursoDao.findByAutorName(termo);
        List<br.edu.ifrs.mostra.dto.AutorCursoDto> autoresCursoDto = new ArrayList<>();
        
        autoresCurso.forEach(autorCurso -> {
            
            br.edu.ifrs.mostra.dto.AutorCursoDto autorCursoDto = new br.edu.ifrs.mostra.dto.AutorCursoDto();
            
            autorCursoDto.setIdAutor(autorCurso.getAutorCursoPK().getFkAutor());
            autorCursoDto.setNome(autorCurso.getAutor().getUsuario().getNome());
            autorCursoDto.setIdCurso(autorCurso.getCurso().getIdCurso());
            autorCursoDto.setNomeCurso(autorCurso.getCurso().getNome());
            
            autoresCursoDto.add(autorCursoDto);
        });
        
        String autoresLista = gson.toJson(autoresCursoDto);
        return autoresLista;
    }
    
    @GET
    @Path("/buscar_orientador/{termo}")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarOrientador(@PathParam("termo") String termo) {
        
        List<OrientadorCampus> orientadoresCampus = orientadorCampusDao.findbyOrientadorName(termo);
        List<br.edu.ifrs.mostra.dto.OrientadorCampusDto> orientadoresCampusDto = new ArrayList<>();
        
        orientadoresCampus.forEach(oC -> {
            br.edu.ifrs.mostra.dto.OrientadorCampusDto oCDto = new br.edu.ifrs.mostra.dto.OrientadorCampusDto();
            
            oCDto.setIdCampus(oC.getCampus().getIdCampus());
            oCDto.setIdOrientador(oC.getOrientadorCampusPK().getFkOrientador());
            oCDto.setNome(oC.getOrientador().getUsuario().getNome());
            oCDto.setNomeCampus(oC.getCampus().getNome());
            
            orientadoresCampusDto.add(oCDto);
        });
        
        String orientadoresLista = gson.toJson(orientadoresCampusDto);
        
        return orientadoresLista;
        
    }
    
    @POST
    @Path("salvar")
    public Response salvarEdicao(@FormParam("trabalho.id_trabalho") int idTrabalho,
                             @FormParam("trabalho.titulo") String titulo, 
                             @FormParam("trabalho.resumo") String resumo, 
                             @FormParam("trabalho.cursos_ids" ) ArrayList cursosIds,
                             @FormParam("trabalho.autores_ids") ArrayList autoresIds,
                             @FormParam("trabalho.campus_id") ArrayList campusIds,
                             @FormParam("trabalho.orientadores_ids") ArrayList orientadoresIds,
                             @FormParam("trabalho.area_tematica") int areaTematica,
                             @FormParam("trabalho.categoria") int categoria,
                             @FormParam("trabalho.modalidade") int modalidade,
                             @FormParam("trabalho.nivel") int nivel,
                             @FormParam("trabalho.palavras_chave") ArrayList palavrasChave) { 
        Trabalho trabalho;
        LocalDate localDate = LocalDate.now();
        
        if (idTrabalho != 0) {
            trabalho = this.trabalhoDao.findOneById(idTrabalho);
            trabalho.setDataAtualizacao(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        else {
            trabalho = new Trabalho();
            trabalho.setDataCadastro(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        
        
        trabalho.setTitulo(titulo);
        trabalho.setResumo(resumo);
        trabalho.setFkArea(new Area(areaTematica));
        trabalho.setFkModalidade(new Modalidade(modalidade));
        trabalho.setNivel(nivel);
        
        
        try {
            
            trabalho.setPalavra1(palavrasChave.get(0).toString());
            trabalho.setPalavra2(palavrasChave.get(1).toString());
            trabalho.setPalavra3(palavrasChave.get(2).toString());
        } catch (IndexOutOfBoundsException e) {
            
        }
        
        trabalho = trabalhoDao.save(trabalho);
        
        int auxId = 0;
        for (Object autorId : autoresIds) {
            
            AutorCurso autorCurso = this.autorCursoDao.findOneBy((int) autorId,(int) cursosIds.get(auxId));
            
            TrabalhoAutorCurso tac = new TrabalhoAutorCurso();
            tac.setAutor(autorCurso.getAutor());
            tac.setEmailTrabalho(autorCurso.getAutor().getUsuario().getEmail());
            tac.setFkCurso(autorCurso.getCurso());
            tac.setSeq(0);
            tac.setTrabalho(trabalho);
            
            trabalhoAutorCursoDao.save(tac);
            
            auxId++;
        }
        
        auxId = 0;
        for (Object orientadorId : orientadoresIds) {
            
            OrientadorCampus orientadorCampus = this.orientadorCampusDao.findOneBy((int)orientadorId, (int)campusIds.get(auxId) );
            
            TrabalhoOrientadorCampus toc = new TrabalhoOrientadorCampus();
            
            toc.setCampus(orientadorCampus.getCampus());
            toc.setEmailTrabalho(orientadorCampus.getOrientador().getUsuario().getEmail());
            toc.setOrientador(orientadorCampus.getOrientador());
            toc.setSeq(0);
            toc.setTrabalho(trabalho);
            
            this.trabalhoOrientadorCampusDao.save(toc);
            
            auxId++;
        }       
        
        return Response.ok().build();
    }


   
    @GET
    @Path("/{id}")
    public String obterTrabalho(@PathParam("id") int id) {
    
        Trabalho t = this.trabalhoDao.findOneById(id);
        TrabalhoDto dto = new TrabalhoDto();
        
        dto.setApoiadores(t.getApoiadores());
        dto.setArea(new AreaDto(t.getFkArea().getIdArea(), t.getFkArea().getNome()) );
        dto.setCategoria(new CategoriaDto(t.getFkCategoria().getIdCategoria(), t.getFkCategoria().getNome()));
        dto.setDataAtualizacao(t.getDataAtualizacao());
        dto.setDataCadastro(t.getDataCadastro());
        dto.setFkSessao(t.getFkSessao() == null ? 0 : t.getFkSessao().getIdSessao());
        dto.setIdTrabalho(t.getIdTrabalho());
        dto.setIpAtualizacao(t.getIpAtualizacao());
        dto.setIpCadastro(t.getIpCadastro());
        dto.setListaAutores(new ArrayList<>());
        dto.setListaOrientadores(new ArrayList<>());
        t.getTrabalhoAutorCursoList().forEach(tac -> {
            
            dto.getListaAutores().add(new AutorCursoDto(tac.getAutor().getUsuario().getNome(),
            tac.getAutor().getUsuario().getIdUsuario(),
            tac.getFkCurso().getIdCurso(), 
            tac.getFkCurso().getNome()));
        });
        
        t.getTrabalhoOrientadorCampusList().forEach(toc -> {
            
            dto.getListaOrientadores().add(new OrientadorCampusDto(toc.getCampus().getIdCampus(), 
                    toc.getCampus().getNome(), 
                    toc.getOrientador().getUsuario().getIdUsuario(), 
                    toc.getOrientador().getUsuario().getNome()));
            
        });
        
        dto.setModalidade(new ModalidadeDto(t.getFkModalidade().getIdModalidade(), t.getFkModalidade().getNome()));
        dto.setNivel(new NivelDto(t.getNivel(), t.getNivel() == 1 ? "técnico" : "superior"));
        dto.setNota(t.getNota());
        dto.setPalavra1(t.getPalavra1());
        dto.setPalavra2(t.getPalavra2());
        dto.setPalavra3(t.getPalavra3());
        dto.setPremiado(t.getPremiado());
        dto.setResumo(t.getResumo());
        dto.setResumo2(t.getResumo2());
        dto.setSeqSessao(t.getSeqSessao());
        dto.setStatus(t.getStatus());
        dto.setTitulo(t.getTitulo());
        dto.setTituloOrdenar(t.getTituloOrdenar());
        dto.setTurno1(t.getTurno1());
        dto.setTurno2(t.getTurno2());
        dto.setTurno3(t.getTurno3());
        
        String trabalhoJson = gson.toJson(dto);
        
        return trabalhoJson;
    }
    
    public List<Trabalho> listarTrabalhoPeloAutor() {
        
        Usuario user = loginBean.getUser();
        return this.trabalhoDao.findByIdAutor(user.getIdUsuario());
    }
    
    public List<Trabalho> listarTrabalhoPeloOrientador() {
        
        Usuario user = loginBean.getUser();
        return this.trabalhoDao.findByIdOrientador(user.getIdUsuario());
    }
    
}
