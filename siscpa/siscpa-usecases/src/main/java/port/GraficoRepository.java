package port;

import fai.cpa.entities.GraficoModel;
import fai.cpa.entities.GrupoDePerguntasModel;

import java.util.List;

public interface GraficoRepository {

    int create(GraficoModel grafico);

    List<GraficoModel> findAllByInstituicaoId(int instituicaoId);

    GraficoModel findById(int id);

    List<GraficoModel> findAll();

    List<GraficoModel> findObjetivaByAvaliacaoId(int avaliacaoId);
}
