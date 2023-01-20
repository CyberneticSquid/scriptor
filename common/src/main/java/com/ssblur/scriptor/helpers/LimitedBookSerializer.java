package com.ssblur.scriptor.helpers;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.StringTag;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LimitedBookSerializer {
  static class Page {
    String text;
    public Page(String text) {
      this.text = text;
    }
  }

  /**
   * Transform a book's pages ListTag into a single String for processing.
   * @param text A book's pages ListTag
   * @return A single string, with no spaces between pages.
   */
  public static String decodeText(ListTag text) {
    Gson gson = new Gson();
    Type type = new TypeToken<Page>() {}.getType();
    StringBuilder builder = new StringBuilder();
    for(Tag tag: text) {
      Page page = gson.fromJson(tag.getAsString(), type);
      builder.append(page.text.strip());
    }
    return builder.toString();
  }

  /**
   * A helper for encoding a String as a book-compatible JSON list.
   * @param text The text to encode.
   * @return An encoded JSON string
   */
  public static ListTag encodeText(String text) {
    Gson gson = new Gson();
    List<Page> list = new ArrayList<>();
    int index = 0;
    int max;
    while(index < text.length()) {
      max = Integer.min(index + 96, text.length());
      list.add(new Page(text.substring(index, max)));
      index += 96;
    }

    ListTag tag = new ListTag();
    for(Page page: list)
      tag.add(StringTag.valueOf(gson.toJson(page)));

    return tag;
  }
}
