from marianoinput import PenguinPrompt
pen= PenguinPrompt()

age=pen.prompt_int_range("whats you age ?", 18,100)
height=pen.prompt_float_range("whats you height in meters ?",1,3)
yesno= pen.prompt_yesno("Do you wish to continue ?")
print(age, height, yesno)
