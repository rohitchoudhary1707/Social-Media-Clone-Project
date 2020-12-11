
import com.vmm.JHTTPServer;
import static com.vmm.NanoHTTPD.HTTP_OK;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mywebserver extends JHTTPServer {

    public mywebserver(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {

        Response res = null;
        String result = "";
        res = new Response(HTTP_OK, "text/plain", "Server Started");
        if (uri.contains("/SignUp")) {

            String email = parms.getProperty("email");
            String name = parms.getProperty("name");
            String pass = parms.getProperty("password");
            String secq = parms.getProperty("secq");
            String mobile = parms.getProperty("mobile");
            String securityans = parms.getProperty("securityans");
//            String photo=parms.getProperty("photo");
            String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/Pics");

            try {

//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/instagram", "root", "rohit@123");
//                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = DBLoader.executeQuery("select * from users where email='" + email + "'");
                if (rs.next()) {
                    result = "User already exists";

                } else {
                    rs.moveToInsertRow();
                    rs.updateString("email", email);
                    rs.updateString("username", name);
                    rs.updateString("password", pass);
                    rs.updateString("security_question", secq);
                    rs.updateString("security_answer", securityans);
                    rs.updateString("phoneno", mobile);
                    rs.updateString("photo", "src/Pics/" + filename);

                    rs.insertRow();

                    result = "success";

                }

                res = new Response(HTTP_OK, "text/plain", result);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/login")) {

            try {
                String username = parms.getProperty("username");
                String password = parms.getProperty("password");

                ResultSet rs = DBLoader.executeQuery("select * from users where username = '" + username + "' and password ='" + password + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                }
            } catch (SQLException ex) {
                Logger.getLogger(mywebserver.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.contains("/editprofile")) {
            try {
                String name = parms.getProperty("name");
                String email = parms.getProperty("email");
                String phoneno = parms.getProperty("phoneno");
                String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/Pics");
                ResultSet rs = DBLoader.executeQuery("select * from users where username='" + name + "'");
                if (rs.next()) {

                    rs.updateString("email", email);
                    rs.updateString("phoneno", phoneno);
                    rs.updateString("photo","src/Pics/"+ photo);
                    rs.updateRow();

                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                }

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if(uri.contains("/changepassword")){
            {
                String oldpass=parms.getProperty("oldpass");
                String newpass=parms.getProperty("newpass");
                String username=parms.getProperty("username");
                System.out.println(username+" "+oldpass);
                ResultSet rs = DBLoader.executeQuery("select * from users where username = '"+username+"' and password='"+oldpass +"'");
                try {
                    if(rs.next()){
//                        rs.moveToCurrentRow();
                        rs.updateString("password",newpass);
                        rs.updateRow();
                         res = new Response(HTTP_OK, "text/plain", "success");
                    }
                         else {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                }
                }
               catch (SQLException ex) {
//                Logger.getLogger(mywebserver.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
               }
            }
        }
        else if(uri.contains("/usersearch")){
            String search=parms.getProperty("search");
            String ans="";
             ResultSet rs = DBLoader.executeQuery("select * from users where username like '%"+search+"%'");
            try {
                while(rs.next())
                {
                    String name=rs.getString("username");
                    String email=rs.getString("email");
                    String phoneno=rs.getString("phoneno");
                    String photo=rs.getString("photo");
                    ans=ans+name+";"+email+";"+phoneno+";"+photo+"~";
                }
                
                          res = new Response(HTTP_OK, "text/plain", ans);
                
            } catch (SQLException ex) {
//                Logger.getLogger(mywebserver.class.getName()).log(Level.SEVERE, null, ex);
            
            ex.printStackTrace();
            }
             
            
        }
       else if (uri.contains("/GetResource")) //request should be of the form /GetResource/one.jpg
        {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri +" *** " );
            res = sendCompleteFile(uri);
        }
       else if(uri.contains("/followuser"))
       {
           String ans1="";
           
           try{
               String name=parms.getProperty("followed_to");
               System.out.println(name);
               String username=parms.getProperty("followed_by");
               System.out.println(username);
            ResultSet rs = DBLoader.executeQuery("select * from follow where followed_by='"+username+"' and followed_to='"+name+"'");
            if(rs.next()){
                rs.deleteRow();
                ans1="deleted";
            }else{
                rs.moveToInsertRow();
                rs.updateString("followed_to",name);
                rs.updateString("followed_by",username);
                rs.insertRow();
                ans1="inserted";
  
            }
               System.out.println("ans1"+ans1);
               res = new Response(HTTP_OK, "text/plain", ans1);
           }
           catch(Exception ae)
           {
               ae.printStackTrace();
           }
       }
       else if(uri.contains("/checkfollow"))
       {
           String username=parms.getProperty("username");
           String name=parms.getProperty("name");
           String ans="";
           ResultSet rs = DBLoader.executeQuery("select * from follow where followed_by='"+username+"' and followed_to='"+name+"'");
           try{
               if(rs.next())
               {
                   ans="yes";
                   
               }
               else
               {
                   ans="no";
               }
                res = new Response(HTTP_OK, "text/plain", ans);
           }
           catch(Exception ae)
           {
               ae.printStackTrace();
           }
           
       }
          else if(uri.contains("/myfollowers"))
          {
              String username=parms.getProperty("username");
              String ans="";
               ResultSet rs = DBLoader.executeQuery("select * from follow where followed_to='"+username+"'");
              try{
                  while(rs.next())
                  {
                      String name=rs.getString("followed_by");
                       ResultSet rs2= DBLoader.executeQuery("select * from users where username='"+name+"'");
                       if(rs2.next())
                       {
                           String email=rs2.getString("email");
                            String mobileno=rs2.getString("phoneno");
                             String photo=rs2.getString("photo");
                            ans=ans+name+";"+email+";"+mobileno+";"+photo+"~";
                           
                       }
                      
                  }
                  System.out.println(" "+ans); 
                  res=new Response(HTTP_OK,"text/plain",ans);
              }
              catch(Exception ae)
              {
                  ae.printStackTrace();
              }
          }
         else if(uri.contains("/myfollowings"))
          {
              String username=parms.getProperty("username");
              String ans="";
               ResultSet rs = DBLoader.executeQuery("select * from follow where followed_by='"+username+"'");
              try{
                  while(rs.next())
                  {
                      String name=rs.getString("followed_to");
                       ResultSet rs2= DBLoader.executeQuery("select * from users where username='"+name+"'");
                       if(rs2.next())
                       {
                           String email=rs2.getString("email");
                            String mobileno=rs2.getString("phoneno");
                             String photo=rs2.getString("photo");
                            ans=ans+name+";"+email+";"+mobileno+";"+photo+"~";
                           
                       }
                      
                  }
                  System.out.println(" "+ans); 
                  res=new Response(HTTP_OK,"text/plain",ans);
              }
              catch(Exception ae)
              {
                  ae.printStackTrace();
              }
          }
         else if(uri.contains("/addpost"))
         {
             String username=parms.getProperty("username");
             String caption=parms.getProperty("caption");
             String filename="";
             filename=saveFileOnServerWithRandomName(files,parms,"photo","src/Pics");
             try{
               ResultSet rs = DBLoader.executeQuery("select * from post"); 
               rs.moveToInsertRow();
               rs.updateString("username",username);
                rs.updateString("caption",caption);
                 rs.updateString("photo","src/Pics/"+filename);
                 rs.insertRow();
//              res=new Response(HTTP_OK,"text/plain","inserted");
               ResultSet rs2 = DBLoader.executeQuery("select max(pid) as pid from post"); 
               if(rs2.next()){
                   int  pid=rs2.getInt("pid");
                    res=new Response(HTTP_OK,"text/plain",pid+"");
               }
             }
             catch(Exception ae)
             {
                 ae.printStackTrace();
             }
         }
        else if(uri.contains("/addstory"))
         {
            // String username=parms.getProperty("username");
             String caption=parms.getProperty("caption");
              int pid=Integer.parseInt(parms.getProperty("pid"));
            String filename=saveFileOnServerWithRandomName(files,parms,"photo","src/Pics");
             try{
               ResultSet rs = DBLoader.executeQuery("select * from story"); 
               rs.moveToInsertRow();
//               rs.updateString("username",username);
                rs.updateString("caption",caption);
                  rs.updateInt("pid",pid);
                 rs.updateString("photo","src/Pics/"+filename);
                 rs.insertRow();
                 res=new Response(HTTP_OK,"text/plain","success");
         }  catch (SQLException ex) {
               // Logger.getLogger(mywebserver.class.getName()).log(Level.SEVERE, null, ex)
               ex.printStackTrace();
            }
         }
        else if(uri.contains("/loadstories1"))
        {
             String pid=parms.getProperty("pid");
             String ans = "";
             ResultSet rs = DBLoader.executeQuery("select * from story where pid="+pid); 

             try{
                  while(rs.next())
                       {
                             String caption=rs.getString("caption");
                             String photo=rs.getString("photo");
                             String sid=rs.getString("sid");
                            ans=ans+caption+";"+photo+";"+sid+"~";
                           
                       }
                  System.out.println(ans); 
                  res=new Response(HTTP_OK,"text/plain",ans);
             }
             
     catch(Exception ex) 
     {
         ex.printStackTrace();
     }
        }
          else if(uri.contains("/close"))
          {
            
                String sid=parms.getProperty("sid");
                ResultSet rs = DBLoader.executeQuery("select * from story where sid="+sid);
                try {
                if(rs.next())
                {
                   rs.deleteRow();
                   res=new Response(HTTP_OK,"text/plain","deleted");
                }
            } catch (SQLException ex) {
               // Logger.getLogger(mywebserver.class.getName()).log(Level.SEVERE, null, ex);
               ex.printStackTrace();
            }
            
            
          }
         else if(uri.contains("/getfollowers"))
         {
        String username=parms.getProperty("username");
        String ans="";
        ResultSet rs = DBLoader.executeQuery("select * from follow where followed_by='"+username+"'");
        try{
            while(rs.next())
            {
                String name=rs.getString("followed_to");
               ResultSet rs2 = DBLoader.executeQuery("select * from post where username='"+name+"'");  
               while(rs2.next())
               {
                   String caption=rs2.getString("caption");
                   String photo=rs2.getString("photo");
                   String pid=rs2.getString("pid");
                   String datetime=rs2.getString("datetime");
                       ans=ans+name+";"+caption+";"+photo+";"+pid+";"+datetime+"~";     
               }
            }
               System.out.println(ans);
              res=new Response(HTTP_OK,"text/plain",ans);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
       

              
         }
         else if(uri.contains("/showstory1"))
         {
              String ans="";
               int pid=Integer.parseInt(parms.getProperty("pid"));
      ResultSet rs = DBLoader.executeQuery("select * from story where pid="+pid);
               try {
                while(rs.next())
                {
                      String caption=rs.getString("caption");
                    String photo=rs.getString("photo");
                    ans=ans+caption+";"+photo+"~";    
                }
                System.out.println("ans-->"+ans);
              res=new Response(HTTP_OK,"text/plain",ans);
            }
            
            catch (SQLException ex) {
               // Logger.getLogger(mywebserver.class.getName()).log(Level.SEVERE, null, ex);
               ex.printStackTrace();
            }

         }
         else if(uri.contains("/likepost"))
         {
              String username=parms.getProperty("username");
         int pid=Integer.parseInt(parms.getProperty("pid"));
             System.out.println("username"+username+" "+"pid="+pid);
      ResultSet rs = DBLoader.executeQuery("select * from liketable where pid="+pid+" and username='"+username+"'");
                     try {
                 if(rs.next())
                 {
                     rs.deleteRow();
                     System.out.println("deleted");
                      res=new Response(HTTP_OK,"text/plain","deleted");
                 }
                 else
                 {
                      rs.moveToInsertRow();
                rs.updateInt("pid",pid);
                rs.updateString("username",username);
                rs.insertRow();
                     System.out.println("inserted");
                res=new Response(HTTP_OK,"text/plain","inserted");
                 }
             } catch (Exception ex) {
                 ex.printStackTrace();
             }
                        
               

         }
         else if(uri.contains("/checklike"))
                 {
            String username=parms.getProperty("username");
           String pid=parms.getProperty("pid");
           String ans="";
         
     ResultSet rs = DBLoader.executeQuery("select * from liketable where pid="+pid+" and username='"+username+"'");

           try{
               if(rs.next())
               {
                   ans="yes";
                   
               }
               else
               {
                   ans="no";
               }
                res = new Response(HTTP_OK, "text/plain", ans);
           }
           catch(Exception ae)
           {
               ae.printStackTrace();
           }
                 }
         else if(uri.contains("/count"))
              {
                 String pid=parms.getProperty("pid");
      ResultSet rs = DBLoader.executeQuery("select * from liketable where pid="+pid);
                  try {
                      int count=0;
                        while(rs.next())
                        {
                            count++;
                        }
                        res=new Response(HTTP_OK,"text/plain",count+"");
                  } catch (Exception ex) {
                      ex.printStackTrace();
                  }
              }
        else if(uri.contains("/profileset")){
            try {
                String r="";
                String user=parms.getProperty("username");
                ResultSet rs=DBLoader.executeQuery("select * from users where username='"+user+"'");
                if(rs.next()){
                    String email=rs.getString("email");
                    String phone=rs.getString("phoneno");
                    String photo=rs.getString("photo");
                    r=r+email+";"+phone+";"+photo;
                    System.out.println(r);
                }
                res= new Response(HTTP_OK,"text/plain",r);
            } catch (SQLException ex) {
//                Logger.getLogger(mywebserver.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            }
        }
        return res; //To change body of generated methods, choose Tools | Templates.
    }
    
}
