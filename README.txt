COMP 472 Project Deliverable 2

by
Daniel Miller - 6602002
Yash Lalwani - 6531857

We certify that this submission is the original work of members of the group and meets the
Faculty's Expectations of Originality

Signed Daniel Miller and Yash Lalwani, 10th November, 2014.

Instructions to run Deliverable 1:

1) Extract the datasets and ensure that the folders which contain the emails,
"20030228_easy_ham_2.tar" and "20030228_spam_2.tar" are in the 'Filter' project folder,
along with the 'src' and 'build' folders.

2) The required files are 'ProbabilityCalculator.java' and 'Tokenizer.java', and are 
part of the 'Filter' package.

3) Run the 'Tokenizer.java' file as it contains the main method. It will run create
'Model.txt' in the project folder.

Description of assumptions made for Tokenisation:

1) All words are converted to lowercase as soon as being read.

2) Words only 2 letters long or shorter are ignored.

3) Words consisting of digits are ignored.

4) Hyphenated words are treated as separate words.

5) Words with apostrophes originally in them are split, usually leaving only 
the section before the apostrophe.

6) Anything between "<>" is assumed to be an HTML tag and not part of the message content.

7) A list of words commonly found in the email header are ignored, using a switch case, 
such as "mime" and "delivered".

8) We assume that the emails obey general grammar and spelling rules as much as possible.

9) We are aware that the spam folder is missing 3 files before the "01000.xxx" file, but decided
to run it for a 1000 spam files in total anyway.

=================================================================================================

Instructions to run Deliverable 2:

1) Extract the datasets and ensure that the folders which contain the emails,
"20030228_easy_ham_2.tar" and "20030228_spam_2.tar" are in the 'Filter' project folder,
along with the 'src' and 'build' folders.

2) The required files are 'Tokenizer.java', 'Model.java', 'Classifier.java', 
'Word.java' and 'model.txt', and are part of the 'Filter' package.

3) Run the 'Classifier.java' as it contains the main method.

The only changes we made to our Deliverable 1 code was to move the main from 
'Tokenizer.java' to 'Classifier.java', and delegate the tokenization to a generic method.

Please note that we took the instructions to be literal and wrote our code so that it
checks files named '01001.xxx to 01400.xxx' from the 'spam' folder and files named 
'01000.xxx to 01400.xxx' from the 'ham' folder.