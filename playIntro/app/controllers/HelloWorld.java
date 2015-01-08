package controllers;

import org.joda.time.DateTime;

import play.libs.F;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Result;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import views.html.*;

public class HelloWorld extends Controller{
	
    public static Result holaMundo() {
        return ok("Hola Mundo.");
    }

    public static Result hoy() {
        return ok(hoy.render(DateTime.now().toString()));       
    }
    
    
    private static Promise<Boolean> isPrime(int number) {        
    	
    	// some processing...    	

    	return (Promise<Boolean>) TODO;    	
    }
    
    public static Promise<Result> isPrimeAction(int number)
    {
    	Promise<Result> response = isPrime(number).map(new F.Function<Boolean, Result>() {
    		@Override
    		public Result apply(Boolean isPrime) throws Throwable {
    			
    			/*
    			 *  thread secundario
    			 */    			
    			
    			return ok(isPrime.toString());
    		}    		
		});
    	    	
		/*
		 *  thread principal
		 */
    	
    	return response;
    }    
}
