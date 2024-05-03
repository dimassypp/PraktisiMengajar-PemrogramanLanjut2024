/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihangeneric;

/**
 *
 * @author DIMAS
 */
public class LatihanGeneric<T> {
	private T t;
	
        public LatihanGeneric(T value) {
            this.t=value;
        }
	public T get(){
            return this.t;
	}
	public void set(T value){
            this.t=value;
	}
	
        
	public static void main(String args[]){
            LatihanGeneric<Integer> t1 = new LatihanGeneric<>(10);
            t1.set(22);
            System.out.println(t1.get());
            
            LatihanGeneric<String> t2 = new LatihanGeneric<>("Tess");
            t2.set("Haii");
            System.out.println(t1.get());
	}
}