# SampleTabbed
How to communicate between activity and fragments in MVVM?

Create a ViewModel "SharedViewModel" that is shared between the Main activity and the fragments

Components in the activity and fragments are binded to the same variable

 "activity2fragment" is readwrite from the activity and readonly in each fragment, so whatever you enter in the TextInputEditText "@+id/activity2fragment" will be visible in the TextView "@+id/activity2fragment" in each fragment.
 
 "tab1text" in tab1_fragment, "tab2text" in tab2_fragment & "tab3text" tab3_fragment are readwrite from the fragments and readonly in the activity, so whatever you enter in any of the TextInputEditText "@+id/tab1text","@+id/tab3text","@+id/tab3text" will be combined and displayed in the TextView "@+id/fragment2activity" in the activity
