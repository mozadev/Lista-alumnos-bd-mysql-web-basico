

<%@page import="java.util.ArrayList"%>


<%@page import ="dao.UsuarioDAO"%>
<%@page import ="dto.Usuario"%>

<%
    String codigo=request.getParameter("txtCodigo");
    ArrayList<Usuario>list=new ArrayList<>();
   // list=UsuarioDAO.ListaUsuario(codigo);
    list=UsuarioDAO.ListadoUsuarios();
    
    if(list==null){
  out.print("no se encontro el usuario");
    }
    else{
    out.println("LISTADO DE ALUMNOS:  "+"\n");
     for (int i = 0; i < list.size(); i++) {
         out.println(""+list.get(i).getLogiUsua());
         
        }
    
    }
   
   
    %>

