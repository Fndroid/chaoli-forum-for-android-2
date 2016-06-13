package com.geno.chaoli.forum.meta;

import android.text.SpannableString;

public class SFXUtils
{
	public static String removeAllSFX(String string)
	{
		return string.replaceAll("\\[c=.+?\\]", "").replaceAll("\\[/c\\]", "")			// For [c=red] blah [/c]
		.replaceAll("\\[curtain\\]", "").replaceAll("\\[/curtain\\]", "")				// For [curtain] blah [/curtain]
		.replaceAll("\\[b\\]", "").replaceAll("\\[/b\\]", "")							// For [b] blah [/b]
		.replaceAll("\\[i\\]", "").replaceAll("\\[/i\\]", "")							// For [i] blah [/i]
		.replaceAll("\\[u\\]", "").replaceAll("\\[/u\\]", "")							// For [u] blah [/u]
		.replaceAll("\\[s\\]", "").replaceAll("\\[/s\\]", "")							// For [s] blah [/s]
		.replaceAll("\\[h\\]", "").replaceAll("\\[/h\\]", "")							// For [h] blah [/h]
		.replaceAll("\\[center\\]", "").replaceAll("\\[/center\\]", "")					// For [center] blah [/center]
		.replaceAll("\\[url=.+?\\]", "").replaceAll("\\[/url\\]", "")					// For [url=url] blah [/url]
/*!*/	.replaceAll("\\[img\\]", "").replaceAll("\\[/img\\]", "")						// For [img] url [/img]
		.replaceAll("\\[code\\]", "").replaceAll("\\[/code\\]", "")						// For [code] code [/code]
		.replaceAll("\\[quote=.*?\\]", "").replaceAll("\\[/quote\\]", "")				// For [quote=blah] blah [/quote]
		;
	}

	static final class SpannableStringUtils
	{
		static SpannableString concatString(SpannableString s1, SpannableString s2)
		{
			SpannableString s3 = new SpannableString(s1.toString() + s2.toString());
			for (Object span : s1.getSpans(0, s1.length() - 1, Object.class))
				s3.setSpan(span, s1.getSpanStart(span), s1.getSpanEnd(span), s1.getSpanFlags(span));
			for (Object span : s2.getSpans(0, s2.length() - 1, Object.class))
				s3.setSpan(span, s2.getSpanStart(span) + s1.length(), s2.getSpanEnd(span) + s1.length(), s2.getSpanFlags(span));
			return s3;
		}

		static SpannableString mergeSpan(SpannableString s1, SpannableString s2)
		{
			if (s1.toString().equals(s2.toString()))
			{
				SpannableString s3 = new SpannableString(s1);
				for (Object span : s2.getSpans(0, s2.length() - 1, Object.class))
					s3.setSpan(span, s2.getSpanStart(span), s2.getSpanEnd(span), s1.getSpanFlags(span));
				return s3;
			}
			else
				return concatString(s1, s2);
		}
	}
}
