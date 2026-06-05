Problem Statement-->
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
Example 1: Input: nums = [1,2,3,1]
Output: true
Explanation:The element 1 occurs at the indices 0 and 3.
Example 2:Input: nums = [1,2,3,4]
Output: false
Explanation:All elements are distinct.
Example 3:Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
Solution-->
Method 1: Using a HashSet
Let us take up a sample input array arr [] = {4, 3, 2, 8, 2, 3, 1}
One way to solve this problem is to use a HashSet.
A HashSet is a set data structure that does not allow you to add duplicate values. 
For example, if the set has values {2, 3, 5} and you try to add 5 again, it will not be added to the set.

Here is how we can find the duplicates in the array using this method-->
->Create a HashSet that will store all the unique integers.
->Create a resultSet that will have all the duplicate integers.
->Iterate through all elements of the array and add it to the set.
->If the element is already present in the set, you can add the element to the result set.
Return the result set.
->The time complexity and space complexity will be O(n) and O(n)
  -->CODE <--
public boolean containsDuplicate(int[] nums){
  //create a hashSet to store the number
  Set<Integer, Integer> set = new HashSet<>();
  //iterate over each element
  for(int i = 0; i < nums.length; i++){
     //check the number in hashset
    if(set.contains(nums[i])){
      return true;
    }
    //add the number to hashseet
    set.add(nums[i]);
    
  }
  return false;
}

Method 2: Using constant space
The tricky part about this problem is to solve it in constant space.
In the above method we just discussed, you need an extra space of O(n).
That is because each element could occur once. The problem challenges you to solve this in constant space.
Let us take up the array once again arr[] = {4, 3, 2, 8, 2, 3, 1}
You are also given a condition that no element of the array would be smaller than 0 and
larger than the size of the array. This gives you a very interesting hint about the solution.
Each element in the array is a valid position in the array also.

We can use property to our advantage. So element 4 could also point at arr[4]. 
This way if we are looking at arr[4] twice, this means that 4 is repeated in the array and is a duplicate.
We have to make sure that we are not using any extra space.
To make this possible make the element negative. This helps to keep a track of the visited element.

->Start traversing each element in the array.
->For each element, navigate to the position in the array.
->If the element is positive, make it negative.
->If the element is already negative, it means we were already here,
hence add the element to the list of duplicates.
->At the end return the duplicate set.
 ->TC And SC = O(n) and O(1) 

  --->CODE <---
  public List<Integer> containsDuplicate(int[] nums){
  List<Integer> set = new ArrayList<>();
  for(int i = 0; i < nums.length; i++){
    // Get the index, the element corresponds to
    int index = Math.abs(nums[i]) - 1;
    // If the number is already negative, it means we are 
      // encountering it twice
    if(nums[index] > 0){
      set.add(index + 1);
      // Flip the number at the index to negative
      nums[index] = nums[index] * -1;
    }
    return set;
  }
  }
  
