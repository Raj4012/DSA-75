// Problem is asking that you have given an array of integers and find out two intergers which sum up to 
//to a specific target. it is assumed there is only one solution.

// --> BRUTE FORCE APPROCH ---> //
 A brute force approach will be :
   1.Start a loop that traverse each element of the array.
   2.start an inner loop that again traverse each element of the arr except the element selected from the first loop.
   3.check if the sum of both elements equal the target sum, if yes, then return the indices.

   target = 19
   nums = [16, 8 , 23, 4, 15]
   --> 16 + 8 = 24
   16 + 23 = 39
   16 + 4 = 20
   16 + 15 = 31
   Now, 8 + 23 = 31 like that will get the 4 + 15 = 19--> which got tar value having indices [3 , 4];
 this method is working fine but the problem is time taken by it is O(n^2), as we traversing all the element of arr two times.
//

// ---> OPTIMIZE METHOD--> Sorting----> //
   we can get the sum advantage if the arr is already sorted, approch to solve by it will be:
 1.Sort the arr.
 2.Start two pointer, Poiter A starts from the beginning of the arr, such that it points to the smallest ele, Pointer B starts from the end of arr, pointing
   at the max ele of the arr.
 3.Now start a while loop While(pnter A < pnter B).
  4.Get a sum of the ele at Pointer A and Pointer B.
 5.if the sum is less than target, it means we need to add a bigger number, hence move the pointer A one step ahead.
   else, we need a smaller number, and we can move the pointer B one step backward.
 6. Somewhere along this iteration, we will get our desired indices.
   CODE-->
   int[] twoSum(int[] nums, int tar){
   int[] copyArr = Arrays.copyOf(nums, nums.length);
   Arrays.sort(copyArr);
   int left = 0;
   int right = copyArr.length - 1;
   int num1 = 0, num2 = 0;
   while(left < right){
     int sum = copyArr[left] + copyArr[right];
     if(sum < tar){
       left++;
     }else if(sum > tar){
       right--;
     }else{
       num1 = copyArr[left];
       num2 = copyArr[right];
       break;
     }
   }
   //create the result arr with indices.
   int[] result = new int[2];
   for(int i = 0; i < nums.length; i++){
     if(nums[i] == nums1) result[0] = i;
     if(nums[i] == nums2) result[1] = i;
   }
   return result;
   }
 the above method works in time complexity of O(n * logn) bcz the sorting.

// ---> OPTIMIZE METHOD--> Using HashMap----> //   
   Instead of finding two numbers whose sum equal to a target value, we can think of the problem in an alternative way.
  [ tar_value  - first_num = second_num]
  so the following way will be steps to solve the problem;
1.Intialize a hash-table that will store the index and the element.
2.Start to traverse the arr.
3.for each ele in the arr use the above define formula to find the complementing number.
4.Look up the complementing number in the hash-table. if found, return the 2 indices.
5.Else, add the ele along with its index to the hah-table and proceed with the other elements.
       <----CODE--->  
int[] twoSum(int[])nums, int tar){
    //create a HashMap
   Map<Integer, Integer> map = new HashMap<>();
   for(int i = 0; i < nums.length; i++){
       // get the complement using the tar value;
    int complement = tar - nums[i];
      //search the hashmap for complement , if found, we got pair
     if(map.containsKey(complement)){
         return new int[]{map.get(complement), i};
     }  
       //put the element in hashMap for subsequent searches
       map.put(nums[i], i);
   }
throw new IllegalArgumentException("No two sum solution");
}
