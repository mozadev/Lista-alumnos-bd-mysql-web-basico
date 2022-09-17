package dao;

import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {

   static ArrayList<Usuario> lista = null;
    static Usuario objUsuario = null;

    public static ArrayList<Usuario> ListaUsuario(String codigo) {

        try {

            String sql = "select * from usuario where codiUsua like '%" + codigo + "%';";
            PreparedStatement pstmt = MySQL.getConexionBD().prepareStatement(sql);
            //pstmt.setString(1, codigo);
            ResultSet rst = pstmt.executeQuery();
            lista = new ArrayList<>();
            while (rst.next()) {
                objUsuario = new Usuario();
                objUsuario.setCodiUsua(rst.getString(1));
                objUsuario.setLogiUsua(rst.getString(2));
                objUsuario.setPassUsua(rst.getString(3));
                lista.add(objUsuario);

            }

        } catch (Exception ex) {
            return null;
        }
        return lista;

    }
    
      public static ArrayList<Usuario> ListadoUsuarios() {

        try {

            String sql = "select * from usuario ;";
            PreparedStatement pstmt = MySQL.getConexionBD().prepareStatement(sql);
          
            ResultSet rst = pstmt.executeQuery();
            lista = new ArrayList<>();
            while (rst.next()) {
                objUsuario = new Usuario();
                objUsuario.setCodiUsua(rst.getString(1));
                objUsuario.setLogiUsua(rst.getString(2));
                objUsuario.setPassUsua(rst.getString(3));
                lista.add(objUsuario);

            }

        } catch (Exception ex) {
            return null;
        }
        return lista;

    }

    public static void main(String[] args) {

         ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista = UsuarioDAO.ListaUsuario("1");
       
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getLogiUsua());
        }
        
    }

}
