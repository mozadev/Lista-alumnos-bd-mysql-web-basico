
package dao;

import static dao.UsuarioDAO.lista;
import static dao.UsuarioDAO.objUsuario;
import dto.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MySQL {
   
    public static Connection getConexionBD() {
         ArrayList<Usuario> lista = null;
        Connection cn=null;
         PreparedStatement pt=null;
         ResultSet rs=null;
        try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              cn=DriverManager.getConnection("jdbc:mysql://localhost/distribuido","root","");
              System.out.println("conexion exitosa");
              pt = cn.prepareStatement("SELECT * FROM usuario;");
              ResultSet rst = pt.executeQuery();
              lista = new ArrayList<Usuario>();
               while (rst.next()) {
                objUsuario = new Usuario();
                objUsuario.setCodiUsua(rst.getString(1));
                objUsuario.setLogiUsua(rst.getString(2));
                objUsuario.setPassUsua(rst.getString(3));
                lista.add(objUsuario);

            }
               
               for (int i = 0; i < lista.size(); i++) {
                   System.out.println(lista.get(i).getLogiUsua());
                
            }

              
        } catch (Exception e) {
            System.out.println("no se conecto");
            
        }
        return cn;
        
    }
    
    public static void main(String[] args) {
        MySQL obj=new MySQL();
        obj.getConexionBD();
    }
    
}
