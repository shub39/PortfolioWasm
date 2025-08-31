package com.shub39.portfolio.data

import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.brands.Twitter
import compose.icons.fontawesomeicons.solid.Envelope

val SOCIAL_LINKS = listOf(
    ButtonInfo(
        FontAwesomeIcons.Brands.Github,
        "https://github.com/shub39",
        "Github"
    ),
    ButtonInfo(
        FontAwesomeIcons.Brands.Linkedin,
        "https://www.linkedin.com/in/shub39/",
        "LinkedIn"
    ),
    ButtonInfo(
        FontAwesomeIcons.Solid.Envelope,
        "mailto:cptnshubham39@gmail.com",
        "Email"
    ),
    ButtonInfo(
        FontAwesomeIcons.Brands.Twitter,
        "https://x.com/_shub39",
        "twitter"
    )
)