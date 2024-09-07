//package fai.cpa.connection.repository;
//
//import fai.cpa.entities.InstituicaoModel;
//import port.InstituicaoRepository;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//public class FakeInstituicaoDao implements InstituicaoRepository {
//
//    private final Map<Integer, InstituicaoModel> database;
//
//    public FakeInstituicaoDao(){
//        this.database =new HashMap<>();
//        populateData();
//    }
//    private static int ID = 0;
//    private static int generateId(){
//        ID += 1;
//        return ID;
//    }
//
//    private void populateData() {
//        final InstituicaoModel firstInstituicao = new InstituicaoModel();
//        firstInstituicao.setId(generateId());
//        firstInstituicao.setCnpj("11.111.111/1111-11");
//        firstInstituicao.setEmail("insituicao1@email.com");
//        firstInstituicao.setNome_fantasia("Instituicao 1");
//        firstInstituicao.setRazao_social("Instituicao Social 1");
//        firstInstituicao.setResponsavelNome("Pessoa 1");
//        firstInstituicao.setResponsavelTelefone(12345678);
//        firstInstituicao.setResposavelEmail("pessoa@email.com");
//        firstInstituicao.setSituacao("Em análise");
//        firstInstituicao.setTelefone(12345678);
//
//        database.put(firstInstituicao.getId(), firstInstituicao);
//    }
//
//
//    @Override
//    public InstituicaoModel findById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<InstituicaoModel> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<InstituicaoModel> findByCriteria(Map<String, String> criteria) {
//        return null;
//    }
//
//    @Override
//    public boolean update(InstituicaoModel instituicaoModel) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteById(int id) {
//        return false;
//    }
//
//    @Override
//    public int create(InstituicaoModel instituicaoModel) {
//        return 0;
//    }
//}
