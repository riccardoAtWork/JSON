//package model;
//
//import java.sql.SQLException;
//
//public class Main {
//
//  public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");
//
//    CategoriaFitService service = new CategoriaFitService();
//    SocioService socioService = new SocioService();
//    // Creates and persists a campo
//    
//    //Campo cam = service.createCampo(3, "brutto");
//    //Campo cam = service.createCampo((long)4,BigDecimal.valueOf(0),Date.from(Instant.now()), "Gino", "Italia", "Terra" );
//    
//    Socio socio = socioService.findSocio(1);
//    System.out.println("Socio: " + socio.getFirstName());
//    
//    CategoriaFit cat = service.createCat("3345", "5", socio);
//    String nTessera = cat.getNTessera();
//    System.out.println("Cat Persisted : " + nTessera);
//
//    // Finds the book
//    cat = service.findCat(nTessera);
//
//    System.out.println("Cat Found     : " + cat.getNTessera());
//
//
//    // Removes the campo
//    //service.removeCampo((long)3);
//
//    //System.out.println("Campo Removed");
//
//    // Finds the book
//    //cam = service.findCampo((long)3);
//
//    //System.out.println("Campo Not Found : " + cam);
//  }
//}
//
//
