package Tietovarastopaketti;

/**
 *
 * @author s1601385
 */

    public class UserBean implements java.io.Serializable {
   private String username = null;
   private String password = null;


   public UserBean() {
   }
   public String getUserName(){
      return username;
   }
   public String getPassword(){
      return password;
   }
  
   
   public void setUsername(String username){
      this.username = username;
   }
   public void setLastName(String passWord){
      this.password = password;
   }
   
}
