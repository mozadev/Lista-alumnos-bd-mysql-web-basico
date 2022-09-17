


<%@page import="java.nio.file.FileSystemNotFoundException"%>
<%@page import="com.itextpdf.text.Phrase"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="dto.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Document"%>


<% 

    
    String listadoALUMNO=" ";
    ArrayList<Usuario>list=new ArrayList<>();
 
    list=UsuarioDAO.ListadoUsuarios();
    
    if(list==null){
  out.println("no se encontro el usuario");
    }
    else{
   
     for (int i = 0; i < list.size(); i++) {
         //out.print(" usuario: "+list.get(i).getLogiUsua());
         listadoALUMNO=listadoALUMNO+list.get(i).getLogiUsua()+" ";
        }
    
    }
      Document document=new Document();
      String destino="REPORTE.pdf";
       PdfWriter.getInstance(document, new FileOutputStream(destino));
       document.open();
         Phrase  titulo =new Phrase("Listado de alumnos: ");
       document.add(titulo);
       Phrase  p =new Phrase(listadoALUMNO);
       document.add(p);
       
       
       document.close();
       out.println("creado pdf");

       

%>