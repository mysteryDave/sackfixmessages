package org.sackfix.fix42

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX42.xml
  */
case class MassQuoteMessage(quoteReqIDField:Option[QuoteReqIDField]=None,
                            quoteIDField:QuoteIDField,
                            quoteResponseLevelField:Option[QuoteResponseLevelField]=None,
                            defBidSizeField:Option[DefBidSizeField]=None,
                            defOfferSizeField:Option[DefOfferSizeField]=None,
                            noQuoteSetsField:NoQuoteSetsField,
                            quoteSetsGroups: List[QuoteSetsGroup]) extends SfFixMessageBody("i")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteSetsField.value != quoteSetsGroups.size)
    throw SfRepeatingGroupCountException(NoQuoteSetsField.TagId,noQuoteSetsField.value, quoteSetsGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteReqIDField.foreach(fmt(b,_))
    fmt(b,quoteIDField)
    quoteResponseLevelField.foreach(fmt(b,_))
    defBidSizeField.foreach(fmt(b,_))
    defOfferSizeField.foreach(fmt(b,_))
    fmt(b,noQuoteSetsField)
    b
  }

}
     
object MassQuoteMessage extends SfFixMessageDecoder {
  val MsgType="i"
  val MsgName="MassQuote"
             
  override val MandatoryFields = HashSet[Int](
    QuoteIDField.TagId, NoQuoteSetsField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    QuoteSetsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteReqIDField.TagId, QuoteResponseLevelField.TagId, DefBidSizeField.TagId, DefOfferSizeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    QuoteSetsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    QuoteSetsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteSetsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MassQuoteMessage(myFields.get(QuoteReqIDField.TagId).flatMap(f=>QuoteReqIDField.decode(f)),
        QuoteIDField.decode(myFields.get(QuoteIDField.TagId)).get,
        myFields.get(QuoteResponseLevelField.TagId).flatMap(f=>QuoteResponseLevelField.decode(f)),
        myFields.get(DefBidSizeField.TagId).flatMap(f=>DefBidSizeField.decode(f)),
        myFields.get(DefOfferSizeField.TagId).flatMap(f=>DefOfferSizeField.decode(f)),
        NoQuoteSetsField.decode(myFields.get(NoQuoteSetsField.TagId)).get,
        if (nextTagPosLookup.contains(NoQuoteSetsField.TagId)) QuoteSetsGroup.decode(flds, nextTagPosLookup(NoQuoteSetsField.TagId)).get else List.empty))
    } else None
  }

    
}
     