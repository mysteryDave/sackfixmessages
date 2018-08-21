package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class QuoteCancelMessage(quoteReqIDField:Option[QuoteReqIDField]=None,
                              quoteIDField:QuoteIDField,
                              quoteCancelTypeField:QuoteCancelTypeField,
                              quoteResponseLevelField:Option[QuoteResponseLevelField]=None,
                              partiesComponent:Option[PartiesComponent]=None,
                              accountField:Option[AccountField]=None,
                              accountTypeField:Option[AccountTypeField]=None,
                              tradingSessionIDField:Option[TradingSessionIDField]=None,
                              tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                              noQuoteEntriesField:Option[NoQuoteEntriesField]=None,
                              quoteEntriesGroups: Option[List[QuoteEntriesGroup]]=None) extends SfFixMessageBody("Z")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteEntriesField.map(_.value).getOrElse(0) != quoteEntriesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoQuoteEntriesField.TagId,noQuoteEntriesField.map(_.value).getOrElse(0), quoteEntriesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteReqIDField.foreach(fmt(b,_))
    fmt(b,quoteIDField)
    fmt(b,quoteCancelTypeField)
    quoteResponseLevelField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    noQuoteEntriesField.foreach(fmt(b,_))
    quoteEntriesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object QuoteCancelMessage extends SfFixMessageDecoder {
  val MsgType="Z"
  val MsgName="QuoteCancel"
             
  override val MandatoryFields = HashSet[Int](
    QuoteIDField.TagId, QuoteCancelTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || QuoteEntriesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteReqIDField.TagId, QuoteResponseLevelField.TagId, AccountField.TagId, AccountTypeField.TagId, TradingSessionIDField.TagId, 
    TradingSessionSubIDField.TagId, NoQuoteEntriesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || QuoteEntriesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || QuoteEntriesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteEntriesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteCancelMessage(myFields.get(QuoteReqIDField.TagId).flatMap(f=>QuoteReqIDField.decode(f)),
        QuoteIDField.decode(myFields.get(QuoteIDField.TagId)).get,
        QuoteCancelTypeField.decode(myFields.get(QuoteCancelTypeField.TagId)).get,
        myFields.get(QuoteResponseLevelField.TagId).flatMap(f=>QuoteResponseLevelField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(NoQuoteEntriesField.TagId).flatMap(f=>NoQuoteEntriesField.decode(f)),
        if (nextTagPosLookup.contains(NoQuoteEntriesField.TagId)) QuoteEntriesGroup.decode(flds, nextTagPosLookup(NoQuoteEntriesField.TagId)) else None))
    } else None
  }

    
}
     