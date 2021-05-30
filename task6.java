package acl_Task6;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class task6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRE("S,qSt,qS,p");
		LRE("S,SbS,SyS,q");
		LRE("S,SyT,T;T,TzF,F;F,d");
		LRE("S,GF,Fd;G,SF,GS,p;F,SG,p");
		LRE("S,SpT,Sq,T,b;T,qSb,iqKb,i;K,SdK,S");

	}


	public static String LRE(String s) {
		s = s.replaceAll("\\s", "");
		String[] first_split = s.split(";");
		String newJ = new String();
		;
		String newJ2 = new String();
//		System.out.println(first_split[1]);
		int i = 0;
		for (int j = 0; j < first_split.length; j++) {
			String[] arrayJ = first_split[j].split(",");

			for (i = 0; i < j; i++) {
				String[] arrayI = first_split[i].split(",");

				for (int z = 1; z < arrayJ.length; z++) {

					if (arrayJ[z].charAt(0) == arrayI[0].charAt(0)) {

						newJ = arrayJ[0];
						for (int kk = 1; kk < z; kk++) {
							newJ += ",";
							newJ += arrayJ[kk];
						}
						for (int x = 1; x < arrayI.length; x++) {
							newJ += ",";
							newJ += arrayI[x] + arrayJ[z].substring(1);
						}

						for (int ahmed = z + 1; ahmed < arrayJ.length; ahmed++) {
							newJ += "," + arrayJ[ahmed];
						}

//						System.out.println(z);
//						for(int q = z ; q < arrayJ.length ; q++) {
//							System.out.println(arrayJ[q]);
//							newJ =  newJ + "," + arrayJ[q];
//						}
//						while(jjj < arrayJ.length) {
//							newJ+="," ;
//							newJ +=  arrayJ[jjj];
//							jjj++;
//						}

						first_split[j] = newJ;
						z = 1;
						arrayJ = first_split[j].split(",");
					}
				}
			}

			ArrayList<String> alpha = new ArrayList<String>();
			ArrayList<String> beta = new ArrayList<String>();
//			System.out.println("xXXXXXXx");
			for (i = 1; i < arrayJ.length; i++) {
				if (arrayJ[i].charAt(0) == arrayJ[0].charAt(0)) {
					alpha.add(arrayJ[i].substring(1));
//					System.out.println("Alpha " + arrayJ[i].substring(1));
				} else {
					beta.add(arrayJ[i]);
//					System.out.println("Beta " + arrayJ[i]);

				}
			}

			if (alpha.size() > 0) {
				newJ = "" + arrayJ[0];
				for (i = 0; i < beta.size(); i++) {
					newJ += ",";
					newJ += beta.get(i);
					newJ += arrayJ[0] + "'";
				}
				newJ2 = new String();
				newJ2 = "" + arrayJ[0] + "'";
				for (i = 0; i < alpha.size(); i++) {
//					System.out.println(alpha.get(i) + "" + alpha.size());
					newJ2 += ",";
					newJ2 += alpha.get(i);
					newJ2 += arrayJ[0] + "'";
				}
				newJ2 += ",e";

//				System.out.println(newJ2);
				first_split = insertX(first_split, newJ2, j + 2);

				first_split[j] = newJ;
				j++;
//				
//				System.out.println(newJ + "          " + newJ2);

//				System.out.println(first_split[1+1]);;

			}

		}

		String result = first_split[0];
		for (i = 1; i < first_split.length; i++) {
			result += ";";
			result += first_split[i];
		}

		System.out.println(result);
		System.out.println();
		return result;
	}

	// Function to insert x in arr at position pos
	public static String[] insertX(String arr[], String x, int pos) {
		int n = arr.length;
		int i;

		// create a new array of size n+1
		String newarr[] = new String[n + 1];

		// insert the elements from
		// the old array into the new array
		// insert all elements till pos
		// then insert x at pos
		// then insert rest of the elements
		for (i = 0; i < n + 1; i++) {
			if (i < pos - 1)
				newarr[i] = arr[i];
			else if (i == pos - 1)
				newarr[i] = x;
			else
				newarr[i] = arr[i - 1];
		}
		return newarr;
	}
}
