/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feistel1;

/**
 *
 * @author TOSHIBA
 */
public class Feistel1 {

    /**
     * @param args the command line arguments
     */
    
    
    static public String encrypt(String plaintext , String key ,String function , int n_of_rounds)
    {
        
        String ciphertext = new String("");
        int n =plaintext.length();
        String leftpart=plaintext.substring(0,n/2);
        String rightpart=plaintext.substring(n/2);
        int le0=Integer.parseInt(leftpart,2);
        int re0=Integer.parseInt(rightpart,2);
        int k=Integer.parseInt(key,2);
        int lep=le0;
        int rep=re0;
        int left_temp , right_temp;
        
        for(int i=0;i<n_of_rounds;i++)
           {
               
               left_temp=rep;
               right_temp=rep;
               if (function=="AND")
                 {
                     right_temp=rep&k;
                 }
               if(function=="OR")
                 {
                     right_temp=rep|k;
                 }
               if(function=="xor")
                 {
                     right_temp=rep^k;
                 }
        rep=right_temp ^ lep;
        lep=left_temp;
           }
        int temp = rep;
        rep=lep;
        lep=temp;
        leftpart=Integer.toBinaryString(lep);
        rightpart=Integer.toBinaryString(rep);
        if (leftpart.length()<(n/2))
           {
               for (int i=0;i<=((n/2)-leftpart.length());i++)
                 {
                     leftpart='0'+leftpart;
                     
                 }
           }
        if (rightpart.length()<(n/2))
           {
               for (int i=0;i<=((n/2)-rightpart.length());i++)
                 {
                     rightpart='0'+rightpart;
                 }
            }
        
        ciphertext=leftpart+rightpart;
        return ciphertext;
        }
     static public String decrept(String ciphertext , String key ,String function , int n_of_rounds)
    {
        
        String plaintext = new String("");
        int n =ciphertext.length();
        String leftpart=ciphertext.substring(0,n/2);
        String rightpart=ciphertext.substring(n/2);
        int ld0=Integer.parseInt(leftpart,2);
        int rd0=Integer.parseInt(rightpart,2);
        int k=Integer.parseInt(key,2);
        int ldp=ld0;
        int rdp=rd0;
        int left_temp , right_temp;
        
        for(int i=0;i<n_of_rounds;i++)
           {
               
               left_temp=rdp;
               right_temp=rdp;
               if (function=="AND")
                 {
                     right_temp=rdp&k;
                 }
               if(function=="OR")
                 {
                     right_temp=rdp|k;
                 }
               if(function=="xor")
                 {
                     right_temp=rdp^k;
                 }
        rdp=right_temp ^ ldp;
        ldp=left_temp;
           }
        int temp = rdp;
        rdp=ldp;
        ldp=temp;
        leftpart=Integer.toBinaryString(ldp);
        rightpart=Integer.toBinaryString(rdp);
        if (leftpart.length()<(n/2))
           {
               for (int i=0;i<=((n/2)-leftpart.length());i++)
                 {
                     leftpart='0'+leftpart;
                     
                 }
           }
        if (rightpart.length()<(n/2))
           {
               for (int i=0;i<=((n/2)-rightpart.length());i++)
                 {
                     rightpart='0'+rightpart;
                 }
            }
        
        plaintext=leftpart+rightpart;
        return plaintext;
        }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
