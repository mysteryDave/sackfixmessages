package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class ListStrikePriceMessage(listIDField:ListIDField,
                                  totNoStrikesField:TotNoStrikesField,
                                  lastFragmentField:Option[LastFragmentField]=None,
                                  noStrikesField:NoStrikesField,
                                  strikesGroups: List[StrikesGroup],
                                  noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                  underlyingsGroups: Option[List[UnderlyingsGroup]]=None) extends SfFixMessageBody("m")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noStrikesField.value != strikesGroups.size)
    throw SfRepeatingGroupCountException(NoStrikesField.TagId,noStrikesField.value, strikesGroups.size)
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,listIDField)
    fmt(b,totNoStrikesField)
    lastFragmentField.foreach(fmt(b,_))
    fmt(b,noStrikesField)
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ListStrikePriceMessage extends SfFixMessageDecoder {
  val MsgType="m"
  val MsgName="ListStrikePrice"
             
  override val MandatoryFields = HashSet[Int](
    ListIDField.TagId, TotNoStrikesField.TagId, NoStrikesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    StrikesGroup.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    LastFragmentField.TagId, NoUnderlyingsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    StrikesGroup.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    StrikesGroup.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoStrikesField.TagId, NoUnderlyingsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ListIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ListStrikePriceMessage(ListIDField.decode(myFields.get(ListIDField.TagId)).get,
        TotNoStrikesField.decode(myFields.get(TotNoStrikesField.TagId)).get,
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        NoStrikesField.decode(myFields.get(NoStrikesField.TagId)).get,
        if (nextTagPosLookup.contains(NoStrikesField.TagId)) StrikesGroup.decode(flds, nextTagPosLookup(NoStrikesField.TagId)).get else List.empty,
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None))
    } else None
  }

    
}
     