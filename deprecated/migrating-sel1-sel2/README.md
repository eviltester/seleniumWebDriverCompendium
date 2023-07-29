# Migrating from Selenium 1 to Selenium 2 a worked example case study

## You can download in releases

You can download the generated pdf and the Selenium 1 and Selenium 2 code in the:

https://github.com/eviltester/migrating-sel1-sel2/releases/tag/1.0

## About this book

This book was written in 2011 and updated in 2014 to support migration from Selenium 1 to Selenium 2.

You can find more information about Selenium 1 in my book Selenium Simplified (open sourced)

- http://www.compendiumdev.co.uk/selenium/

This book was the text for a workshop I conducted on Migrating from Selenium 1 to Selenium 2.

It was supported by a subversion repo.

For the purposes of open sourcing this text and releasing it in June 2018 I have:

- only edited the text of this book to allow it to generate a pdf
- amended the source code to be slightly better formatted by using `~~~~~~~~` blocks
- added the images that were missing from the original doc
- line wrapped the source code so it doesn't fall off the page when generated as a pdf
- I have deleted the svn repo but in the repo for this book you will find:
    - `\initial-code`. - revision 2 of the svn repo
    - `\migrated-code` - final revision of the svn repo after making the changes in this book 
    - `\workshop\code_versions_step_by_step` contains separate folders for each of the revisions so you can see the micro code changes from each release to the next - (bonus, I thought I'd lost this)

This was my first attempt at creating a 'case study book'. My most recent case study book is:

- [Automating and Testing a REST API](https://www.compendiumdev.co.uk/page/tracksrestapibook)

The current text you are reading has the issue that source code snippets were copy and pasted into the text making the entire process more labour intensive and error-prone. I didn't spend much time formatting them, and there are many inline code snippets that would benefit from some `code formatting` but I haven't spent the time doing that.

I'm releasing this as a 'historical' artifact. It might still have some value - not in terms of migrating from Selenium1 to Selenium 2 (or 3 at the time of writing). But more in terms of the thought processes used to migrate and refactor code.

You might also gain some value from the page object refactorings that I have used.

I no longer use Ant, I try to avoid annotations when I code so I avoid the Page object annotations from Selenium.

The code will not build as I have not added the dependencies into the repo. I recommend reading the code, rather than running the code - it is very old after all.

I haven't read the text to review its accuracy, I've left the contents pretty much as they were when I last committed in 2014.

- I suspect that most of the URLs listed will not work.

This was originally written to release as a [leanpub](http://leanpub.com) document, so might act as an example of a book formatted for that platform. This current pdf was not generated through leanpub it was generated using:

- https://github.com/eviltester/pandocifier
- https://pandoc.org/

> **No warranty provided - treat as a historical artifact.**
> Alan Richardson , June 2018

- http://eviltester.com
- http://compendiumdev.co.uk
- http://seleniumsimplified.com
- http://javafortesters.com
