package com.tca;

import com.tca.resource.Singleton;

public class App {

	public static void main(String[] args) {
		Singleton s1 =  Singleton.getSingletonResource();
		Singleton s2 =  Singleton.getSingletonResource();
		
		System.out.println(s1);
		System.out.println(s2);
		
	}
}

/*
 	We use singleton design pattern if we want only one instance of an resource or class.
 	like a configuration class, it's common and unique in entire application, so we can create singleton object of configuration class
 	
 	-- Developer or we should not able to create or instantiate the singleton class.
 	-- To achieve this, we declare only one constructor (default) and make it private.
 	
 	-- And we create a static method (So, we can access it without creating object) to get the resource object
 
 	1. Declaration and instantiation.
 		private static Config config = new Config();
 		
 		in this way, when we will use the class for the first time, at the time of class loading, 
 		the static field will be instantiated only for once,
 		but suppose, we don't need the resource right now, then the object will remain in the heap,
 		occupying memory.....
 		
 	2. static Getter method
 		public Config getConfig(){
 			if(config == null)
 				config = new Config();
 			return config;
 		}
 		
 		It's better than the previous version, but there is a catch, 
 		IT's NOT THREAD SAFE !!
 		suppose, two threads are running simultaneously and resource is not yet created
 		and both threads try to get the resource at the same time, suppose thread_1 gets the chance, 
 		it entered the method, and then executed the if condition, since the resource is currently null, it will enter the if block 
 		but before creating the object, suppose the scheduler switched to thread_2, now thread_1 is not executing and thread_2 is trying to get the resource
 		since, thread_1 was unable to create the object of the resource, thread_2 will execute the if block, the resource is still null,
 		thread_2 will enter the if block, it will create the object and get it,
 		now thread_1 comes in the picture again, last time it was stopped just before creating object of resource
 		now it will create the object of that resource again (it will execute next instruction, from where it was stopped)
 		now, thread_1 will create another object of resource, and it's not the singleton design, 
 		In singleton design, there should be only one object of the singleton resource
 
 
 	3. static getter method with Thread Safety
 		To overcome the above problem, we can make the method thread safe by making it synchronized
 		
 		static synchronized Config getConfig() {
 			if(config == null){
 				config = new Config();
 			}
 			return config;
 		}
 		
 		now it's thread safe, only one thread can access the method at a time, 
 		but here the problem is we made the entire method synchronized, suppose the resource is instantiated
 		still, all the thread will wait to access it, if there is another thread has accessed the method.
 		
 		it can reduce performance (theorytically)
 
 	4. static getter method with thread safety and double checking
 	
 	static Config getConfig(){
 		if(config == null){
 			
 			synchronized(Config.class){
 				if(config == null){
 					config = new Config();
 				}
 			}
 		}
 		
 		return config;
 	}
 	
 	It's the best solution
 	suppose there are 3 threads, and initially the resource is null,
 	and all three threads are executing simultaneously, all three threads enter the outer if,
 	now, the synchronized block can be accessed by only one thread at a time, 
 	suppose thread_1 accessed the synchronized block first, 
 	it will execute the inner if and create the object of the resource and leave the synchronized block (frees the lock)
 	now suppose thread_2 enter the synchronized lock, it won't create the new object as the object is already created by the thread_1
 	and the if block won't execute, so it will leave the synchronized block, 
 	thread_3 will also come like thread_2 and go without creating new object
 	
 	now suppose all three has completed...
 	(at this point, object is created)
 	now, 4 new threads come to get the resource 
 	all threads enter the method simultaneously, and since the object is already created, the outer if will result in false
 	so they all will directly get the resource, without waiting....
 	
 	The wait is only for the first time.....
 
 */ 

